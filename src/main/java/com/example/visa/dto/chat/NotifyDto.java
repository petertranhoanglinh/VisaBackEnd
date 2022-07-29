package com.example.visa.dto.chat;

import org.springframework.web.multipart.MultipartFile;

public class NotifyDto {

    private long id = 0;
    private String title;
    private String note;
    private String evenDate;
    private MultipartFile imageData;
    private String image;
    private String range;
    private String imageOld;

    public String getImageOld() {
        return imageOld;
    }

    public void setImageOld(String imageOld) {
        this.imageOld = imageOld;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEvenDate() {
        return evenDate;
    }

    public void setEvenDate(String evenDate) {
        this.evenDate = evenDate;
    }

    public MultipartFile getImageData() {
        return imageData;
    }

    public void setImageData(MultipartFile imageData) {
        this.imageData = imageData;
    }

}
