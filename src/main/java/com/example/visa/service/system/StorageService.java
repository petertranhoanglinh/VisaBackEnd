package com.example.visa.service.system;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface StorageService {
    public Path getRoot(String type);

    public void storeFolder(Path path);

    public String store(MultipartFile file, String type);

    public boolean delete(String fileName, String type);

    public Path load(String fileName, String type);
}
