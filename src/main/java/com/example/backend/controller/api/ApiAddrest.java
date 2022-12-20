package com.example.backend.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/basic")
public class ApiAddrest {
    @GetMapping("/addrestVN")
    public ResponseEntity<?> getAddrestVN(@RequestParam (required = false) String addr1,
            @RequestParam (required = false) String addr2,
            @RequestParam (required = false) String addr3) {
        try {
            return null;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }
        
    }

}
