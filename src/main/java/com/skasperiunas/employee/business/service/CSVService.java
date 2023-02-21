package com.skasperiunas.employee.business.service;

import com.skasperiunas.employee.business.helper.CSVHelper;
import com.skasperiunas.employee.business.repository.EmployeeRepository;
import com.skasperiunas.employee.business.repository.model.EmployeeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CSVService {
    private final EmployeeRepository repository;

    public void saveFile( MultipartFile file ){
        try{
            List<EmployeeEntity> employees = CSVHelper.csvToEmployeeEntity(file.getInputStream());
            repository.saveAll(employees);
        } catch (IOException e) {
            throw new RuntimeException("Error while saving CSV data to Data Base ..." + e.getMessage());
        }
    }
}
