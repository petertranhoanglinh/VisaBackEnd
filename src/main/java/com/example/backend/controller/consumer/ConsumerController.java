package com.example.backend.controller.consumer;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.backend.dto.consumer.ConsumerDto;
import com.example.backend.dto.util.DataExcelHandel;
import com.example.backend.dto.util.ImportExcelDto;
import com.example.backend.service.consumer.ConsumerService;
import com.example.backend.util.ImportExcel;
import com.example.backend.util.MessegeStatus;
import com.example.backend.util.Utils;

@RestController
@RequestMapping("/api/consumer")
public class ConsumerController {
    @Autowired
    ConsumerService service;
    @Autowired
    ImportExcel getImportExcel;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ConsumerDto dto) {
        try {
            
            if(!Utils.isAdmin()) {
                return ResponseEntity.ok(new MessegeStatus("Only admin can register", "0000"));
            }
            long i = this.service.callConsumerSP(dto);
            if (i == 1) {
                return ResponseEntity.ok(new MessegeStatus("Consumer register suscess", "0001"));
            } else if (i == 2) {
                return ResponseEntity.ok(new MessegeStatus("Consumer update suscess", "0001"));
            } else if (i == 3) {
                return ResponseEntity.ok(new MessegeStatus("Phone number already exists", "0000"));
            } else {
                return ResponseEntity.ok(new MessegeStatus("Fail", "0000"));
            }
            
            
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.ok(new MessegeStatus("fail", "0000"));
        }

    }

    @GetMapping("/all/{mobile}/{page}")
    public ResponseEntity<?> getAll(@PathVariable String mobile, @PathVariable int page) {
        try {
            String workUser = Utils.getUserDetail().getUsername();

            return ResponseEntity.ok(this.service.getAll(mobile, workUser, page - 1));

        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }

    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        try {
            if(!Utils.isAdmin()) {
                return ResponseEntity.ok(new MessegeStatus("Only admin can delete", "0000"));
            }
            String workUser = Utils.getUserDetail().getUsername();
            int i = this.service.callConsumerDelSP(id, workUser);

            if (i == 1) {
                return ResponseEntity.ok(new MessegeStatus(" Delete consumer suscess", "0001"));
            } else {
                return ResponseEntity.ok(new MessegeStatus("Fail delete", "0000"));
            }

        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.ok(new MessegeStatus("Fail delete", "0000"));
        }

    }
    
    @GetMapping("/getTestAll")
    public ResponseEntity<?> getTestAll(){
    	try {
			return ResponseEntity.ok("");
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    }
    
    @PostMapping(value = "/importExcel")
    public ResponseEntity<?> addDataByExcel(MultipartFile file){
        try {
            ImportExcelDto excelDto = new ImportExcelDto();
            excelDto.setFileData(file);
            String  []  header = { "name", "mobile" , "address" };
            LinkedHashMap<String, Object>  dataExcel = this.getImportExcel.getExceltoListData(excelDto, header);
            return  ResponseEntity.ok(dataExcel);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

}
