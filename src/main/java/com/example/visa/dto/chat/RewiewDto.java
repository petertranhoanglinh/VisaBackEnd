package com.example.visa.dto.chat;

public class RewiewDto {
    private long pdtId;
    private String comment;
    private int rate;
    private String createBy;

    public long getPdtId() {
        return pdtId;
    }

    public void setPdtId(long pdtId) {
        this.pdtId = pdtId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

}
