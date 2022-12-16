package com.example.backend.service.coin;


import java.util.List;

import com.example.backend.entity.Coin;



public interface CoinService {
    
    public List<Object> getAllCoinGecko() throws  Exception;

    void updateCoin(Coin coin);

}
