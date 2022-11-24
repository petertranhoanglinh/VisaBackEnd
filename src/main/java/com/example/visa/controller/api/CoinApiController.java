package com.example.visa.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.visa.entity.Coin;
import com.example.visa.service.coin.CoinService;
import com.example.visa.service.data.GetDataUrl;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/api/basic")
public class CoinApiController {
    @Autowired CoinService coinService;
    
    @Autowired GetDataUrl data;

    @RequestMapping( value = "/listCoin")
    public @ResponseBody Object getListCoin(@RequestParam(required = false) int page
            ,@RequestParam(required = false) int len,
            @RequestParam(required = false) String ids,
            @RequestParam(required = false) String order,
            @RequestParam(required = false) String price_change_percentage) {
        try {
            String uri = "https://api.coingecko.com/api/v3/coins/markets";
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("vs_currency", "usd");
            params.put("order", order);
            params.put("per_page", len);
            params.put("page", page);
            params.put("sparkline",false);
            params.put("price_change_percentage", price_change_percentage);
            if(ids!=null) {
                params.put("ids", ids);
            }
            List<Object> listCoin = (List<Object>) this.data.getListDataUri(params, uri, new Coin(),"list");
            return   listCoin;
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }
    
    @RequestMapping( value = "/join")
    public @ResponseBody Object joinListCoin(@RequestParam(required = false) int page
            ,@RequestParam(required = false) int len,
            @RequestParam(required = false) String ids,
            @RequestParam(required = false) String order,
            @RequestParam(required = false) String price_change_percentage) {
        
           
            
            try {
                List<Object> objectData = (List<Object>) this.getListCoin(page, len, ids, order, price_change_percentage);
                
                for (Object object : objectData) {
                    this.coinService.updateCoin((Coin) object);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            
            return 0;
    }

}
