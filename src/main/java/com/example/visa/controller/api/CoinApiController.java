package com.example.visa.controller.api;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.visa.dto.coin.CoinDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/api/basic")
public class CoinApiController {

    @RequestMapping( value = "/listCoin")
    public @ResponseBody Object getListCoin(@RequestParam(required = false) int page
            ,@RequestParam(required = false) int len,
            @RequestParam(required = false) String ids,
            @RequestParam(required = false) String order) {
        try {
            String uri = "https://api.coingecko.com/api/v3/coins/markets";
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("vs_currency", "usd");
            params.put("order", order);
            params.put("per_page", len);
            params.put("page", page);
            
            
            if(ids!=null) {
                params.put("ids", ids);
            }
            
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0)
                    postData.append('&');
                postData.append(param.getKey());
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            String url = uri + "?"+postData.toString();
            URL urlConn = new URL(url);
            ObjectMapper obj = new ObjectMapper();
            obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            obj.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            HttpURLConnection con = (HttpURLConnection) urlConn.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setDoOutput(true);
            
            
            String   result = "";
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                result =response.toString();
            }
            List<CoinDto> listCoin = Arrays.asList(obj.readValue(result, CoinDto[].class));
            System.out.println(listCoin.size());
            return  listCoin; 
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }

}
