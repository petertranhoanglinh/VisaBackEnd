package com.example.visa.payment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.visa.util.ConfigVNPAY;
import com.google.gson.JsonObject;



@Controller
public class ApiPaymentController {
    
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
            String vnp_OrderInfo = "";//vnp_OrderInfo
            String orderType = "";//ordertype
            String vnp_TxnRef =  ConfigVNPAY.getRandomNumber(8);
            String vnp_IpAddr = ConfigVNPAY.getIpAddress(request);
            String vnp_TmnCode = ConfigVNPAY.vnp_TmnCode;
            int amount = 1 * 100; // amount *100
            
            
            Map<String, String> vnp_Params = new HashMap<>();
            
            vnp_Params.put("vnp_Version", vnp_Version);
            vnp_Params.put("vnp_Command", vnp_Command);
            vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
            vnp_Params.put("vnp_Amount", String.valueOf(amount));
            vnp_Params.put("vnp_CurrCode", "VND");
            
            String bankcode = "";// bankcode
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
            
            vnp_Params.put("vnp_ReturnUrl", ConfigVNPAY.vnp_Returnurl); // trang wen tra ra sau khi thanh toan 
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
    

}
