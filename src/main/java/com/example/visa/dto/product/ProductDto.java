package com.example.visa.dto.product;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

public class ProductDto {
    private long pdtId;
    private String pdtName;
    private BigDecimal price;
    private String descripton;
    private String pdtKind;
    private String createBy;
    private String startSale;
    private String endSale;
    private String note;
    private String image;
    private String image1;
    private String image2;
    private String imageOld;
    private String imageOld1;
    private String imageOld2;
    private String kindCoin;
    private MultipartFile imageData;
    private MultipartFile imageData1;
    private MultipartFile imageData2;
    private static final long serialVersionUID = 74458L;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public MultipartFile getImageData() {
        return imageData;
    }

    public void setImageData(MultipartFile imageData) {
        this.imageData = imageData;
    }

    public MultipartFile getImageData1() {
        return imageData1;
    }

    public void setImageData1(MultipartFile imageData1) {
        this.imageData1 = imageData1;
    }

    public MultipartFile getImageData2() {
        return imageData2;
    }

    public void setImageData2(MultipartFile imageData2) {
        this.imageData2 = imageData2;
    }

    public String getKindCoin() {
        return kindCoin;
    }

    public void setKindCoin(String kindCoin) {
        this.kindCoin = kindCoin;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getPdtId() {
        return pdtId;
    }

    public void setPdtId(long pdtId) {
        this.pdtId = pdtId;
    }

    public String getPdtName() {
        return pdtName;
    }

    public void setPdtName(String pdtName) {
        this.pdtName = pdtName;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public String getPdtKind() {
        return pdtKind;
    }

    public void setPdtKind(String pdtKind) {
        this.pdtKind = pdtKind;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getStartSale() {
        return startSale;
    }

    public void setStartSale(String startSale) {
        this.startSale = startSale;
    }

    public String getEndSale() {
        return endSale;
    }

    public void setEndSale(String endSale) {
        this.endSale = endSale;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImageOld() {
        return imageOld;
    }

    public void setImageOld(String imageOld) {
        this.imageOld = imageOld;
    }

    public String getImageOld1() {
        return imageOld1;
    }

    public void setImageOld1(String imageOld1) {
        this.imageOld1 = imageOld1;
    }

    public String getImageOld2() {
        return imageOld2;
    }

    public void setImageOld2(String imageOld2) {
        this.imageOld2 = imageOld2;
    }

}
