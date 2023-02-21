package com.skasperiunas.employee.web.controller;

import com.skasperiunas.employee.business.helper.CSVHelper;
import com.skasperiunas.employee.business.message.ResponseMessage;
import com.skasperiunas.employee.business.service.CSVService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employee/csv")
public class CSVController {

    @Autowired
    private final CSVService service;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile( @RequestParam("file") MultipartFile file ) {
        String message = "";

        if(CSVHelper.hasCSVFormat(file)){
            try{
                service.saveFile(file);
                message = "File " + file.getOriginalFilename() + " uploaded successfully !";
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e){
                message = "File " + file.getOriginalFilename() + " can't be uploaded!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload a csv format file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
}
