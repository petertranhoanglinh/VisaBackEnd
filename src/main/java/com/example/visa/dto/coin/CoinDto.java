package com.example.visa.dto.coin;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class CoinDto {
    
    
    private String id ;
    private String symbol;
    private BigDecimal current_price;
    private BigDecimal market_cap;
    private String image;
    private BigDecimal total_volume;
    private BigDecimal price_change_24h;
    private BigDecimal high_24h;
    private BigDecimal low_24h;
    private BigDecimal price_change_percentage_24h;
    private BigDecimal fully_diluted_valuation;
    private BigDecimal total_supply;
    private BigDecimal max_supply;
    private BigDecimal market_cap_change_percentage_24h;
    private BigDecimal market_cap_change_24h;
    private BigDecimal circulating_supply;
    private BigDecimal ath_change_percentage;
    private BigDecimal atl_change_percentage;
    private BigDecimal atl;
    private java.sql.Timestamp ath_date;
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
    public BigDecimal getTotal_volume() {
        return total_volume;
    }
    public void setTotal_volume(BigDecimal total_volume) {
        this.total_volume = total_volume;
    }
    public BigDecimal getPrice_change_24h() {
        return price_change_24h;
    }
    public void setPrice_change_24h(BigDecimal price_change_24h) {
        this.price_change_24h = price_change_24h;
    }
    public BigDecimal getHigh_24h() {
        return high_24h;
    }
    public void setHigh_24h(BigDecimal high_24h) {
        this.high_24h = high_24h;
    }
    public BigDecimal getLow_24h() {
        return low_24h;
    }
    public void setLow_24h(BigDecimal low_24h) {
        this.low_24h = low_24h;
    }
    public BigDecimal getPrice_change_percentage_24h() {
        return price_change_percentage_24h;
    }
    public void setPrice_change_percentage_24h(BigDecimal price_change_percentage_24h) {
        this.price_change_percentage_24h = price_change_percentage_24h;
    }
    public BigDecimal getFully_diluted_valuation() {
        return fully_diluted_valuation;
    }
    public void setFully_diluted_valuation(BigDecimal fully_diluted_valuation) {
        this.fully_diluted_valuation = fully_diluted_valuation;
    }
    public BigDecimal getTotal_supply() {
        return total_supply;
    }
    public void setTotal_supply(BigDecimal total_supply) {
        this.total_supply = total_supply;
    }
    public BigDecimal getMax_supply() {
        return max_supply;
    }
    public void setMax_supply(BigDecimal max_supply) {
        this.max_supply = max_supply;
    }
    public BigDecimal getMarket_cap_change_percentage_24h() {
        return market_cap_change_percentage_24h;
    }
    public void setMarket_cap_change_percentage_24h(BigDecimal market_cap_change_percentage_24h) {
        this.market_cap_change_percentage_24h = market_cap_change_percentage_24h;
    }
    public BigDecimal getMarket_cap_change_24h() {
        return market_cap_change_24h;
    }
    public void setMarket_cap_change_24h(BigDecimal market_cap_change_24h) {
        this.market_cap_change_24h = market_cap_change_24h;
    }
    public BigDecimal getCirculating_supply() {
        return circulating_supply;
    }
    public void setCirculating_supply(BigDecimal circulating_supply) {
        this.circulating_supply = circulating_supply;
    }
    public BigDecimal getAth_change_percentage() {
        return ath_change_percentage;
    }
    public void setAth_change_percentage(BigDecimal ath_change_percentage) {
        this.ath_change_percentage = ath_change_percentage;
    }
    public BigDecimal getAtl_change_percentage() {
        return atl_change_percentage;
    }
    public void setAtl_change_percentage(BigDecimal atl_change_percentage) {
        this.atl_change_percentage = atl_change_percentage;
    }
    public BigDecimal getAtl() {
        return atl;
    }
    public void setAtl(BigDecimal atl) {
        this.atl = atl;
    }
    public String getAth_date() {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ath_date);
        return timeStamp;
    }
    public void setAth_date(java.sql.Timestamp ath_date) {
        this.ath_date = ath_date;
    }
    
    
    
    

}
