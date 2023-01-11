package com.example.backend.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ApiBasicController {
    
    /**
     * @name api address Viet Nam
     * @param addr1
     * @param addr2
     * @param addr3
     * @return
     */
    @GetMapping("/addressVN")
    public ResponseEntity<?> getAddrestVN(@RequestParam (required = false) String addr1,
            @RequestParam (required = false) String addr2,
            @RequestParam (required = false) String addr3) {
        try {
            return null;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        
    }

}
