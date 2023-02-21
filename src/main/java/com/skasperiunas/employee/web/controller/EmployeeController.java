package com.skasperiunas.employee.web.controller;

import com.skasperiunas.employee.business.repository.EmployeeRepository;
import com.skasperiunas.employee.business.repository.model.EmployeeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository repository;

    @GetMapping("/all")
    public List<EmployeeEntity> getAllEmployees(){
        return repository.findAll();
    }
}
