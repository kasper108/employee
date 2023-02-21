package com.skasperiunas.employee.web.controller;

import com.skasperiunas.employee.business.service.UploadServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employee/")
public class UploadController {

    @Autowired
    private final UploadServiceImpl service;

    @PostMapping("/upload")
    public void upload( @RequestParam("file") MultipartFile file ) throws IOException {
        service.getEmployeeInfoFromFile(file);
    }
}
