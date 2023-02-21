package com.skasperiunas.employee.business.repository.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name = "employee_email")
    private String employeeEmail;
    @Column(name = "employee_phone_number")
    private String employeePhoneNumber;
}
