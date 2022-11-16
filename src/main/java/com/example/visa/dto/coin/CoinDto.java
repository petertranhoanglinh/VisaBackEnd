package com.example.visa.dto.coin;

import java.math.BigDecimal;

public class CoinDto {
    
    
    private String id ;
    private String symbol;
    private BigDecimal current_price;
    private BigDecimal market_cap;
    private String image;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public BigDecimal getCurrent_price() {
        return current_price;
    }
    public void setCurrent_price(BigDecimal current_price) {
        this.current_price = current_price;
    }
    public BigDecimal getMarket_cap() {
        return market_cap;
    }
    public void setMarket_cap(BigDecimal market_cap) {
        this.market_cap = market_cap;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    
    

}
