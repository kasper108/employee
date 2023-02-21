package com.skasperiunas.employee.business.service;

import com.skasperiunas.employee.business.repository.model.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeEntity> findAllEmployees();
    Optional<EmployeeEntity> findEmployeeById( Long id);
}
