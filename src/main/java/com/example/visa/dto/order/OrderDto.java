package com.example.visa.dto.order;

import java.math.BigDecimal;

public class OrderDto {
    private String userId;
    private BigDecimal amt;
    private String methodPay;
    public String getUserId() {
        return userId;
    }
    public BigDecimal getAmt() {
        return amt;
    }
    public String getMethodPay() {
        return methodPay;
    }

}
