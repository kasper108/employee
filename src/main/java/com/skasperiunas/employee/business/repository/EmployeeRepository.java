package com.skasperiunas.employee.business.repository;

import com.skasperiunas.employee.business.repository.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
