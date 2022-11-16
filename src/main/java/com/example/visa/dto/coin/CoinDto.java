package com.example.visa.dto.coin;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class CoinDto {
    
    
    private String id ;
    private String symbol;
    private BigDecimal current_price;
    private BigDecimal market_cap;
    private String image;
    
    private java.sql.Timestamp last_updated;
    
    

    public String getLast_updated() {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(last_updated);
        return timeStamp;
    }
    public void setLast_updated(java.sql.Timestamp last_updated) {
        this.last_updated = last_updated;
    }
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
