package com.example.backend.controller.system;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.backend.service.system.StorageService;

@RequestMapping("/api/basic")
public class BasicApiController {
    @Autowired
    private StorageService storageService;
    
    @RequestMapping(path = "/download/{param}/{typeName}", method = RequestMethod.GET)
    public ResponseEntity<Resource> download(@PathVariable String param, @PathVariable String typeName) throws IOException {
        // ...
        Path path = this.storageService.load(param, typeName);
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                //.contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

}
