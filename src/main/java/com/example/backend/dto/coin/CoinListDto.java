package com.example.backend.dto.coin;

import java.util.ArrayList;
import java.util.List;

public class CoinListDto {
    private List<CoinDto> listCoin = new ArrayList<CoinDto>();

    public List<CoinDto> getListCoin() {
        return listCoin;
    }

    public void setListCoin(List<CoinDto> listCoin) {
        this.listCoin = listCoin;
    }
    
    

}
