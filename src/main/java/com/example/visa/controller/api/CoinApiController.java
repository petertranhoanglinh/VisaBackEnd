package com.example.visa.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.visa.dto.coin.CoinDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
@Controller
@RequestMapping("/api/basic")
public class CoinApiController {

    @RequestMapping("/listCoin")

    @ResponseBody public String getListCoin() {
       
        try {
            String uri = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc";

            URL urlConn = new URL(uri);

            ObjectMapper obj = new ObjectMapper();
            obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            obj.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

            HttpURLConnection con = (HttpURLConnection) urlConn.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setDoOutput(true);
            
            
            CoinDto  result = new CoinDto();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                    String jsonResult = response.toString();
                    result = obj.readValue(jsonResult, CoinDto.class);
                }
            }
            System.out.println(result);
            return null;
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }

}
