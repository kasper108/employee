package com.skasperiunas.employee.business.service;

import org.springframework.web.multipart.MultipartFile;

public interface CSVService {
    void saveUploadedFileToDB( MultipartFile file );
}
