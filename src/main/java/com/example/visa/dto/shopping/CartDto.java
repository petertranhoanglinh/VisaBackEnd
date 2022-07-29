package com.example.visa.dto.shopping;

import java.math.BigDecimal;

public class CartDto {
    private String text = "";
    private long id = 0;
    private String coinId = "";
    private BigDecimal quantity = new BigDecimal(0);
    private String sellerId = "";
    private String buyerId = "";
    private String contractS = "";
    private String contractB = "";
    private BigDecimal coinPrice = new BigDecimal(0);
    private int status = 0;
    private String note = "";
    private String optionCoin = "";

    public String getOptionCoin() {
        return optionCoin;
    }

    public void setOptionCoin(String optionCoin) {
        this.optionCoin = optionCoin;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoinId() {
        return coinId;
    }

    public void setCoinId(String coinId) {
        this.coinId = coinId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getContractS() {
        return contractS;
    }

    public void setContractS(String contractS) {
        this.contractS = contractS;
    }

    public String getContractB() {
        return contractB;
    }

    public void setContractB(String contractB) {
        this.contractB = contractB;
    }

    public BigDecimal getCoinPrice() {
        return coinPrice;
    }

    public void setCoinPrice(BigDecimal coinPrice) {
        this.coinPrice = coinPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
