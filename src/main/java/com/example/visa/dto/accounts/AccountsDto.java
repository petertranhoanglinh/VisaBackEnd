package com.example.visa.dto.accounts;

import java.math.BigDecimal;

public class AccountsDto {
    private String accountId;
    private String coinId;
    private BigDecimal quantityCoin;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCoinId() {
        return coinId;
    }

    public void setCoinId(String coinId) {
        this.coinId = coinId;
    }

    public BigDecimal getQuantityCoin() {
        return quantityCoin;
    }

    public void setQuantityCoin(BigDecimal quantityCoin) {
        this.quantityCoin = quantityCoin;
    }
}
