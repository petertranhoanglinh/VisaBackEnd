package com.example.backend.service.coin;


import java.util.List;

import com.example.backend.entity.Coin;
import com.example.backend.model.extend.CoinModel;



public interface CoinService {
    
    public List<Object> getAllCoinGecko() throws  Exception;

    void updateCoin(Coin coin);

    List<CoinModel> getRate7days(int page);

}
