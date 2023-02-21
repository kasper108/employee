package com.skasperiunas.employee.business.service.impl;

import com.skasperiunas.employee.business.repository.EmployeeRepository;
import com.skasperiunas.employee.business.repository.model.EmployeeEntity;
import com.skasperiunas.employee.business.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public List<EmployeeEntity> findAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Optional<EmployeeEntity> findEmployeeById( Long id ) {
        return repository.findById(id);
    }
}
