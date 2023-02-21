package com.skasperiunas.employee.business.service;

import com.skasperiunas.employee.helper.CSVHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UploadServiceImpl {

    private CSVHelper csvHelper;

    public void getEmployeeInfoFromFile(MultipartFile uploadFile) throws IOException {
        csvHelper.
    }
    public File uploadEmployeeFile( MultipartFile uploadFile ) throws IOException {
        File uploadedFile = new File(uploadFile.getOriginalFilename());
        System.out.println(uploadedFile);
        return uploadedFile;
    }
}
