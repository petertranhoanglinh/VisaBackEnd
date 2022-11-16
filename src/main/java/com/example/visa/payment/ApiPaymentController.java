package com.example.visa.payment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.visa.dto.payment.ResultVNpayDto;
import com.example.visa.util.ConfigVNPAY;
import com.example.visa.util.Utils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;




@Controller
public class ApiPaymentController {
    
    // thanh toán
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/VNPAY",
            produces = MediaType.TEXT_PLAIN_VALUE
        )
    @ResponseBody  public ResponseEntity<Object> vnPay(HttpServletRequest request){
        try {
            // property 
            String vnp_Version = "2.1.0";
            String vnp_Command = "pay";
            String vnp_OrderInfo = "Nap tien cho thue bao 0123456789. So tien 100,000 VND";//vnp_OrderInfo
            String orderType = "";//ordertype
            String vnp_TxnRef =  ConfigVNPAY.getRandomNumber(8);
            String vnp_IpAddr = ConfigVNPAY.getIpAddress(request);
            String vnp_TmnCode = ConfigVNPAY.vnp_TmnCode;
            int amount = 10000 * 100; // amount *100
            
            
            Map<String, String> vnp_Params = new HashMap<>();
            
            vnp_Params.put("vnp_Version", vnp_Version);
            vnp_Params.put("vnp_Command", vnp_Command);
            vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
            vnp_Params.put("vnp_Amount", String.valueOf(amount));
            vnp_Params.put("vnp_CurrCode", "VND");
            
            String bankcode = "VNBANK";// bankcode
            String bank_code = bankcode;
            if (bank_code != null && !bank_code.isEmpty()) {
                vnp_Params.put("vnp_BankCode", bank_code);
            }
            
            vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
            vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo);
            vnp_Params.put("vnp_OrderType", orderType);
            
            String locate = "vn"; // language
            
            if (locate != null && !locate.isEmpty()) {
                vnp_Params.put("vnp_Locale", locate);
            } else {
                vnp_Params.put("vnp_Locale", "vn");
            }
            String url_return   = Utils.URL_REST+"/VNPAY/vnpay_ipn";
            vnp_Params.put("vnp_ReturnUrl",url_return ); // trang wen tra ra sau khi thanh toan 
            vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
            
            Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            String vnp_CreateDate = formatter.format(cld.getTime());
            
            
            vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
            cld.add(Calendar.MINUTE, 15);
            String vnp_ExpireDate = formatter.format(cld.getTime());
 
           //Add Params of 2.0.1 Version
            vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
            
            //Billing
            vnp_Params.put("vnp_Bill_Mobile","0582163211"); //txt_billing_mobile
            vnp_Params.put("vnp_Bill_Email", "petertranhoanglinh@gmail.com");  // txt_billing_email
            
            String fullName = ("Tran Hoang Linh").trim(); // txt_billing_fullname
            
            if (fullName != null && !fullName.isEmpty()) {
                int idx = fullName.indexOf(' ');
                String firstName = fullName.substring(0, idx);
                String lastName = fullName.substring(fullName.lastIndexOf(' ') + 1);
                vnp_Params.put("vnp_Bill_FirstName", firstName);
                vnp_Params.put("vnp_Bill_LastName", lastName);
            }
            
            vnp_Params.put("vnp_Bill_Address", "90/1d-ap3-anvien-trangbom"); // txt_inv_addr1
            vnp_Params.put("vnp_Bill_City", "90000");  // txt_bill_city
            vnp_Params.put("vnp_Bill_Country", "8000"); // txt_bill_country
            if (""!= null && !"".isEmpty()) { // txt_bill_state
                vnp_Params.put("vnp_Bill_State", ""); // txt_bill_state
            }
            
            // Invoice
            vnp_Params.put("vnp_Inv_Phone", "02320302");//txt_inv_mobile
            vnp_Params.put("vnp_Inv_Email","peter@gmail.com");//txt_inv_email
            vnp_Params.put("vnp_Inv_Customer", "32132");//txt_inv_customer
            vnp_Params.put("vnp_Inv_Address","3231 le duc tho");//txt_inv_addr1
            vnp_Params.put("vnp_Inv_Company","2323");//txt_inv_company
            vnp_Params.put("vnp_Inv_Taxcode", "232");//txt_inv_taxcode
            vnp_Params.put("vnp_Inv_Type", "2323");//cbo_inv_type
            
            
          //Build data to hash and querystring
            List fieldNames = new ArrayList(vnp_Params.keySet());
            Collections.sort(fieldNames);
            StringBuilder hashData = new StringBuilder();
            StringBuilder query = new StringBuilder();
            Iterator itr = fieldNames.iterator();
            while (itr.hasNext()) {
                String fieldName = (String) itr.next();
                String fieldValue = (String) vnp_Params.get(fieldName);
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    //Build hash data
                    hashData.append(fieldName);
                    hashData.append('=');
                    hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    //Build query
                    query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                    query.append('=');
                    query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    if (itr.hasNext()) {
                        query.append('&');
                        hashData.append('&');
                    }
                }
            }
            
            String queryUrl = query.toString();
            String vnp_SecureHash = ConfigVNPAY.hmacSHA512(ConfigVNPAY.vnp_HashSecret, hashData.toString());
            queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
            String paymentUrl = ConfigVNPAY.vnp_PayUrl + "?" + queryUrl;
         
            
            
       
            
            URL urlConn = new URL (paymentUrl);
            HttpURLConnection con = (HttpURLConnection)urlConn.openConnection();
//            con.setRequestMethod("GET");
//            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//            con.setDoOutput(true);
//            String result = "";
//            try(BufferedReader br = new BufferedReader(
//                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
//                         StringBuilder response = new StringBuilder();
//                         String responseLine = null;
//                         while ((responseLine = br.readLine()) != null) {                    
//                             response.append(responseLine.trim());                   
//                             String jsonResult = response.toString();
//                             
//                             result = jsonResult;
//                         }            
//             }
//            return result;
            
            com.google.gson.JsonObject job = new JsonObject();
            job.addProperty("code", "00");
            job.addProperty("message", "success");
            job.addProperty("data", paymentUrl);
          //  Gson gson = new Gson();
           // String redirectUrl = paymentUrl;
            
            URI redirectUrl = new URI(paymentUrl);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(redirectUrl);
            return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
       //     return "redirect:" + redirectUrl;
           // return gson.toJson(job);
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }
    
    // trang trả ra đơn hằng
    @RequestMapping(value = "VNPAY/vnpay_ipn")
    public String statusOrder(@RequestParam(required = false) String vnp_Amount ,
            @RequestParam(required = false) String vnp_BankCode,
            @RequestParam(required = false) String vnp_BankTranNo,
            @RequestParam(required = false) String vnp_OrderInfo,
            @RequestParam(required = false) String vnp_PayDate,
            @RequestParam(required = false) String vnp_ResponseCode,
            @RequestParam(required = false) String vnp_TmnCode,
            @RequestParam(required = false) String vnp_TransactionNo,
            @RequestParam(required = false) String vnp_TxnRef,
             Model model){
        try {
            
            Map<String, String> vnp_Params = new HashMap<>();
            
            vnp_Params.put("vnp_Amount", vnp_Amount);
            vnp_Params.put("vnp_BankCode", vnp_BankCode);
            vnp_Params.put("vnp_BankTranNo", vnp_BankTranNo);
            vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo);
            vnp_Params.put("vnp_PayDate", vnp_PayDate);
            vnp_Params.put("vnp_ResponseCode", vnp_ResponseCode);
            vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
            vnp_Params.put("vnp_TransactionNo", vnp_TransactionNo);
            vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
            
           
            
          //Build data to hash and querystring
            List fieldNames = new ArrayList(vnp_Params.keySet());
            Collections.sort(fieldNames);
            StringBuilder hashData = new StringBuilder();
            StringBuilder query = new StringBuilder();
            Iterator itr = fieldNames.iterator();
            while (itr.hasNext()) {
                String fieldName = (String) itr.next();
                String fieldValue = (String) vnp_Params.get(fieldName);
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    //Build hash data
                    hashData.append(fieldName);
                    hashData.append('=');
                    hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    //Build query
                    query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                    query.append('=');
                    query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    if (itr.hasNext()) {
                        query.append('&');
                        hashData.append('&');
                    }
                }
            }
            String queryUrl = query.toString();
            String vnp_SecureHash = ConfigVNPAY.hmacSHA512(ConfigVNPAY.vnp_HashSecret, hashData.toString());
            queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
            String paymentUrl = "https://sandbox.vnpayment.vn/tryitnow/Home/VnPayIPN" + "?" + queryUrl;
            
            ObjectMapper obj = new ObjectMapper();
            obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            obj.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            
            URL urlConn = new URL(paymentUrl);

            HttpURLConnection con = (HttpURLConnection) urlConn.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setDoOutput(true);
            ResultVNpayDto result= new ResultVNpayDto();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                    String jsonResult = response.toString();

                    result = obj.readValue(jsonResult, ResultVNpayDto.class);
                }
            }
            model.addAttribute("RspCode", result.getRspCode());
            model.addAttribute("Message", result.getMessage());

            
        } catch (Exception e) {
            // TODO: handle exception
          
        }
        return "payment";
    }
    
    // trang trả ra đơn hằng
    @RequestMapping(value = "VNPAY/test")
    @ResponseBody public ResponseEntity<Object> test(){
        try {
            
            String urlTest = "https://sandbox.vnpayment.vn/tryitnow/Home/VnPayIPN?vnp_Amount=1000000&vnp_BankCode=NCB&vnp_BankTranNo=VNP13876597&vnp_CardType=ATM&vnp_OrderInfo=Nap+tien+cho+thue+bao+0123456789.+So+tien+100%2C000+VND&vnp_PayDate=20221113080600&vnp_ResponseCode=00&vnp_TmnCode=ZEPOPLLX&vnp_TransactionNo=13876597&vnp_TransactionStatus=00&vnp_TxnRef=19678766&vnp_SecureHash=355a9d1c03482cccc465d62975846700b06e5d380b24909896214972d15ed3710b9141e559982f60c167ae31b11a0bcd436f75d19d8e4c6263954cc0f6766fa8";
            URL urlConn = new URL (urlTest);
            HttpURLConnection con = (HttpURLConnection)urlConn.openConnection();
            con.setRequestMethod("GET");
           // con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //con.setDoOutput(true);
            
            ObjectMapper obj = new ObjectMapper();
            obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            obj.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            
            ResultVNpayDto result = new ResultVNpayDto();
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                         StringBuilder response = new StringBuilder();
                         String responseLine = null;
                         while ((responseLine = br.readLine()) != null) {                    
                             response.append(responseLine.trim());                   
                             String jsonResult = response.toString();
                             
                             result = obj.readValue(jsonResult,ResultVNpayDto.class);                  
                         }            
             }
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            // TODO: handle exception
          
        }
        return null;
    }
    

}
