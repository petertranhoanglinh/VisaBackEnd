package com.example.visa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
@DynamicInsert
@Entity
@Table(name = "COIN")
public class Coin  implements Serializable{
    
    
    @Id
    @Column(name = "id")
    private String id ;
   
    @Column(name = "symbol")
    private String symbol;
   
    @Column(name = "current_price")
    private Double current_price;
   
    @Column(name = "market_cap")
    private Long market_cap;
   
    @Column(name = "image")
    private String image;
   
    @Column(name = "total_volume")
    private int total_volume;
   
    @Column(name = "price_change_24h")
    private Double price_change_24h;
   
    @Column(name = "high_24h")
    private Double high_24h;
   
    @Column(name = "low_24h")
    private Double low_24h;
   
    @Column(name = "price_change_percentage_24h")
    private Double price_change_percentage_24h;
    
    @Column(name = "fully_diluted_valuation")
    private int fully_diluted_valuation;
    
    @Column(name = "total_supply")
    private Double total_supply;
    
    @Column(name = "max_supply")
    private Double max_supply;
    
    @Column(name = "market_cap_change_percentage_24h")
    private Double market_cap_change_percentage_24h;
    
    @Column(name = "market_cap_change_24h")
    private int market_cap_change_24h;
    
    @Column(name = "circulating_supply")
    private Double circulating_supply;
    
    @Column(name = "ath_change_percentage")
    private Double ath_change_percentage;
    
    @Column(name = "atl_change_percentage")
    private Double atl_change_percentage;
    
    @Column(name = "atl")
    private Double atl;
    
    @Column(name = "ath_date")
    private String ath_date;
    
    @Column(name = "last_updated")
    private String last_updated;
    
    

    public String getLast_updated() {
       
        return last_updated;
    }
    public void setLast_updated(String last_updated) {
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
    public Double getCurrent_price() {
        return current_price;
    }
    public void setCurrent_price(Double current_price) {
        this.current_price = current_price;
    }
    public Long getMarket_cap() {
        return market_cap;
    }
    public void setMarket_cap(Long market_cap) {
        this.market_cap = market_cap;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public int getTotal_volume() {
        return total_volume;
    }
    public void setTotal_volume(int total_volume) {
        this.total_volume = total_volume;
    }
    public Double getPrice_change_24h() {
        return price_change_24h;
    }
    public void setPrice_change_24h(Double price_change_24h) {
        this.price_change_24h = price_change_24h;
    }
    public Double getHigh_24h() {
        return high_24h;
    }
    public void setHigh_24h(Double high_24h) {
        this.high_24h = high_24h;
    }
    public Double getLow_24h() {
        return low_24h;
    }
    public void setLow_24h(Double low_24h) {
        this.low_24h = low_24h;
    }
    public Double getPrice_change_percentage_24h() {
        return price_change_percentage_24h;
    }
    public void setPrice_change_percentage_24h(Double price_change_percentage_24h) {
        this.price_change_percentage_24h = price_change_percentage_24h;
    }
    public int getFully_diluted_valuation() {
        return fully_diluted_valuation;
    }
    public void setFully_diluted_valuation(int fully_diluted_valuation) {
        this.fully_diluted_valuation = fully_diluted_valuation;
    }
    public Double getTotal_supply() {
        return total_supply;
    }
    public void setTotal_supply(Double total_supply) {
        this.total_supply = total_supply;
    }
    public Double getMax_supply() {
        return max_supply;
    }
    public void setMax_supply(Double max_supply) {
        this.max_supply = max_supply;
    }
    public Double getMarket_cap_change_percentage_24h() {
        return market_cap_change_percentage_24h;
    }
    public void setMarket_cap_change_percentage_24h(Double market_cap_change_percentage_24h) {
        this.market_cap_change_percentage_24h = market_cap_change_percentage_24h;
    }
    public int getMarket_cap_change_24h() {
        return market_cap_change_24h;
    }
    public void setMarket_cap_change_24h(int market_cap_change_24h) {
        this.market_cap_change_24h = market_cap_change_24h;
    }
    public Double getCirculating_supply() {
        return circulating_supply;
    }
    public void setCirculating_supply(Double circulating_supply) {
        this.circulating_supply = circulating_supply;
    }
    public Double getAth_change_percentage() {
        return ath_change_percentage;
    }
    public void setAth_change_percentage(Double ath_change_percentage) {
        this.ath_change_percentage = ath_change_percentage;
    }
    public Double getAtl_change_percentage() {
        return atl_change_percentage;
    }
    public void setAtl_change_percentage(Double atl_change_percentage) {
        this.atl_change_percentage = atl_change_percentage;
    }
    public Double getAtl() {
        return atl;
    }
    public void setAtl(Double atl) {
        this.atl = atl;
    }
    public String getAth_date() {
        return ath_date;
    }
    public void setAth_date(String ath_date) {
        this.ath_date = ath_date;
    }
    
    
    public void setKey(String key, Object  value) throws Exception {
        
        if(key.equals("id")) {
            this.id = (String) value;
        }
        
        if(key.equals("symbol")) {
            this.symbol = (String) value;
        }
        
        if(key.equals("current_price")) {
            this.current_price = (Double)value==null?new Double(0):(Double)value;
        }
        
        if(key.equals("market_cap")) {
            this.market_cap =(Long)value==null?new Long(0):(Long)value;
        }
        
        if(key.equals("id")) {
            this.id = (String) value;
        }
        
        if(key.equals("image")) {
            this.image = (String) value;
        }
        
        if(key.equals("total_volume")) {
            this.total_volume = (Integer)value==null?new Integer(0):(Integer)value;
        }
        
        if(key.equals("price_change_24h")) {
            this.price_change_24h =(Double)value==null?new Double(0):(Double)value;
        }
        
        if(key.equals("high_24h")) {
            this.high_24h = (Double)value==null?new Double(0):(Double)value;
        }
        
        if(key.equals("low_24h")) {
            this.low_24h = (Double)value==null?new Double(0):(Double)value;
        }
        

        if(key.equals("price_change_percentage_24h")) {
            this.price_change_percentage_24h = (Double)value==null?new Double(0):(Double)value;
        }
        
        
        if(key.equals("fully_diluted_valuation")) {
            this.fully_diluted_valuation = (Integer)value==null?new Integer(0):(Integer)value;
        }
        
        if(key.equals("total_supply")) {
            this.total_supply =(Double)value==null?new Double(0):(Double)value;
        }
        
        if(key.equals("max_supply")) {
            this.max_supply = (Double)value==null?new Double(0):(Double)value;
        }
        
        if(key.equals("market_cap_change_percentage_24h")) {
            this.market_cap_change_percentage_24h =(Double)value==null?new Double(0):(Double)value;
        }
        
        if(key.equals("market_cap_change_24h")) {
            this.market_cap_change_24h =(Integer)value==null?new Integer(0):(Integer)value;
        }
        
        
        if(key.equals("atl_change_percentage")) {
            this.atl_change_percentage = (Double)value==null?new Double(0):(Double)value;
        }
        
        
        if(key.equals("atl")) {
            this.atl = (Double)value==null?new Double(0):(Double)value;
        }
        
        
        if(key.equals("ath_date")) {
            this.ath_date =  (String) value;
        }
        
        if(key.equals("last_updated")) {
            this.last_updated =(String) value;
        }
        
        if(key.equals("ath_change_percentage")) {
            this.ath_change_percentage =(Double)value==null?new Double(0):(Double)value;
        }
    }
    

}
