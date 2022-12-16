package com.example.backend.service.data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class GetDataUrl<T> {
    private T t;
    private List<T> listT;

    
    public List<T> getListDataUri( Map<String, Object> params , String uri) throws Exception {
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
             // result data is List
        listT = (ArrayList<T>) obj.readValue(result, new TypeReference<ArrayList<T>>(){});

        return  listT;
        
    }

}
