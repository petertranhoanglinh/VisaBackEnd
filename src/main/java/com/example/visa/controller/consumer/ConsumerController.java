package com.example.visa.controller.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.visa.dto.consumer.ConsumerDto;
import com.example.visa.service.consumer.ConsumerService;
import com.example.visa.util.MessegeStatus;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    ConsumerService service;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ConsumerDto dto) {
        try {
            long i = this.service.callConsumerSP(dto);
            if (i == 1) {
                return ResponseEntity.ok(new MessegeStatus("Consumer register suscess", "0001"));
            } else if (i == 2) {
                return ResponseEntity.ok(new MessegeStatus("Consumer update suscess", "0001"));
            } else {
                return ResponseEntity.ok(new MessegeStatus("fail", "0000"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.ok(new MessegeStatus("fail", "0000"));
        }

    }

}
