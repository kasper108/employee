package com.skasperiunas.employee.web.controller;

import com.skasperiunas.employee.business.repository.EmployeeRepository;
import com.skasperiunas.employee.business.repository.model.EmployeeEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee/")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @RequestMapping
    public EmployeeEntity createEmployee(){
        return employeeRepository.save(new EmployeeEntity());
    }

}
