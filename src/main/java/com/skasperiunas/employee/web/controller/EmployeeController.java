package com.skasperiunas.employee.web.controller;

import com.skasperiunas.employee.business.repository.model.EmployeeEntity;
import com.skasperiunas.employee.business.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("/")
    public List<EmployeeEntity> getAllEmployees(){
        return service.findAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeEntity> getEmployeeById( @PathVariable Long id ){
        return service.findEmployeeById(id);
    }
}
