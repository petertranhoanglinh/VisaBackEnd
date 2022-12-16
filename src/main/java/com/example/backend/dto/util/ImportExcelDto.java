package com.example.backend.dto.util;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class ImportExcelDto implements Serializable{
    
    private MultipartFile fileData;
    
    private static final long serialVersionUID = 1L;

    public MultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(MultipartFile fileData) {
        this.fileData = fileData;
    }

}
