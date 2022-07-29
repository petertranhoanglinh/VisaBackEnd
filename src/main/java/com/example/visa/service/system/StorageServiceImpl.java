package com.example.visa.service.system;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class StorageServiceImpl implements StorageService {
    private final Path rootPdt = Paths.get("./upload/product"); // 1
    private final Path rootUser = Paths.get("./upload/user"); // 2
    private final Path rootCompany = Paths.get("./upload/company"); // 3
    private final Path rootNotify = Paths.get("./upload/notify"); // 4
    private final Path rootCate = Paths.get("./upload/cate"); // 5
    private final Path rootCke = Paths.get("./upload/ckeditor");
    private final Path rootTemp = Paths.get("./upload/myoffice/temp"); // 6
    private final Path rootB01 = Paths.get("./upload/myoffice/B01"); // 7
    private final Path rootB02 = Paths.get("./upload/myoffice/B02"); // 8
    private final Path rootB03 = Paths.get("./upload/myoffice/B03"); // 9
    private final Path rootB04 = Paths.get("./upload/myoffice/B04"); // 10
    private final Path rootB05 = Paths.get("./upload/myoffice/B05"); // 11
    private final Path rootB06 = Paths.get("./upload/myoffice/B06"); // 12
    private final Path rootContents = Paths.get("./upload/myoffice/contents"); // 13
    private final Path rootSchedule = Paths.get("./upload/myoffice/schedule"); // 14
    private final Path rootB00 = Paths.get("./upload/myoffice/B00"); // 15
    private Logger logger = LoggerFactory.getLogger(StorageService.class);

    private Path root;

    @Override
    public Path getRoot(String type) {
        Path root = null;
        switch (type) {
            case "product":
                root = this.rootPdt;
                break;
            case "user":
                root = this.rootUser;
                break;
            case "company":
                root = this.rootCompany;
                break;
            case "notify":
                root = this.rootNotify;
                break;
            case "cate":
                root = this.rootCate;
                break;
            case "ckeditor":
                root = this.rootCke;
                break;
            case "temp":
                root = this.rootTemp;
                break;
            case "B01":
                root = this.rootB01;
                break;
            case "B02":
                root = this.rootB02;
                break;
            case "B03":
                root = this.rootB03;
                break;
            case "B04":
                root = this.rootB04;
                break;
            case "B05":
                root = this.rootB05;
                break;
            case "B06":
                root = this.rootB06;
                break;
            case "contents":
                root = this.rootContents;
                break;
            case "schedule":
                root = this.rootSchedule;
                break;
            case "B00":
                root = this.rootB00;
                break;
        }
        return root;
    }

    @Override
    public String store(MultipartFile file, String type) {
        // TODO Auto-generated method stub
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                logger.error("Failed to store empty file " + fileName);
            }
            if (fileName.contains("..")) {
                // This is a security check
                logger.error(
                        "Cannot store file with relative path outside current directory "
                                + fileName);
            }

            DateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
            int i = fileName.lastIndexOf(".");
            fileName = fileName.substring(0, i).replaceAll(" ", "") + dateFormatter.format(new Date())
                    + fileName.substring(i);

            try (InputStream inputStream = file.getInputStream()) {
                this.root = getRoot(type);
                this.storeFolder(this.root);
                Files.copy(inputStream, this.root.resolve(fileName),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            logger.error("Failed to store file " + fileName + "; " + e.getMessage());
        }

        return fileName;
    }

    @Override
    public boolean delete(String fileName, String type) {
        // TODO Auto-generated method stub
        try {
            Path path = load(fileName, type);
            File file = path.toFile();
            if (file.delete()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error("Failed to delete file " + fileName + "; " + e.getMessage());
            return false;
        }
    }

    @Override
    public Path load(String fileName, String type) {
        // TODO Auto-generated method stub
        this.root = getRoot(type);
        return this.root.resolve(fileName);
    }

    @Override
    public void storeFolder(Path path) {
        // TODO Auto-generated method stub
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            logger.error("Could not initialize storage location: " + e.getMessage());
        }
    }
}
