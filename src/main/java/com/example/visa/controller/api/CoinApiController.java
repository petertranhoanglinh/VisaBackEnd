package com.example.visa.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.visa.entity.Coin;
import com.example.visa.service.coin.CoinService;
import com.example.visa.service.data.GetDataUrl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/api/basic")
public class CoinApiController {
    @Autowired CoinService coinService;
    
    @Autowired GetDataUrl data;

    private List<String> fail = new ArrayList<String>();

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
            List<Coin> listCoin =  this.data.getListDataUri(params, uri);
            return   listCoin;
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }
        
    @RequestMapping( value = "/join")
    public   @ResponseBody Object joinListCoin(@RequestParam(required = false) int page
            ,@RequestParam(required = false) int len,
             @RequestParam(required = false) String ids,
             @RequestParam(required = false) String order,
             @RequestParam(required = false) String price_change_percentage) {       
            try {
                fail.add("");
                List<Coin> reponse = new ArrayList<Coin>();
                int count = 0;
                List< LinkedHashMap<String, Object>> objectData = (List< LinkedHashMap<String, Object>>) this.getListCoin(page, len, ids, order, price_change_percentage);   
                for(LinkedHashMap<String, Object> data : objectData) {
                    Coin model = new Coin();
                    for (String key : data.keySet()) {
                        try {
                            model.setKey(key,data.get(key));
                        } catch (Exception e) {
                            if(!fail.contains(key)){
                                fail.add(key);
                                System.out.println(key + "--" +e.getMessage().substring(50));
                                System.out.println("----------------------------------------");
                                System.out.println("----------------------------------------");
                            }
                           
                        }
                     
                    }
                    reponse.add(model);
                    count ++;
                }
                int i = 0;
                for(Coin coin: reponse) {
                    this.coinService.updateCoin(coin);
                    System.out.println(i++);
                }
                return reponse;
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
               
            }
            return 0;
    }

}
