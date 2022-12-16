package com.example.backend.service.coin;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.dao.extend.CoinDao;
import com.example.backend.dto.coin.CoinDto;
import com.example.backend.entity.Coin;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class CoinServiceImpl implements CoinService{
    @Autowired CoinDao coinDao;

    @Override
    public List<Object> getAllCoinGecko() throws Exception {
        // TODO Auto-generated method stub
//        String uri = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc";
//        
//        URL urlConn = new URL(uri);
//        
//        ObjectMapper obj = new ObjectMapper();
//        obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        obj.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
//        
//        HttpURLConnection con = (HttpURLConnection) urlConn.openConnection();
//        con.setRequestMethod("GET");
//        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//        con.setDoOutput(true);
//    
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
//            StringBuilder response = new StringBuilder();
//            String responseLine = null;
//            while ((responseLine = br.readLine()) != null) {
//                response.append(responseLine.trim());
//                String jsonResult = response.toString();
//
//                result = obj.readValue(jsonResult, CoinDto.class);
//            }
//        }
        return null;
    }
    
    @Override
    public void updateCoin(Coin coin) {
        this.coinDao.save(coin);
    }
    
    

}
