package com.example.visa.service.coin;


import java.util.List;

import com.example.visa.entity.Coin;



public interface CoinService {
    
    public List<Object> getAllCoinGecko() throws  Exception;

    void updateCoin(Coin coin);

}
