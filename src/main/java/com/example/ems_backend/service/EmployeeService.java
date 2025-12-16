package com.example.ems_backend.service;

import java.util.List;

import com.example.ems_backend.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto gEmployeeById (Long employeeID);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto updateEmployee(Long employeeid, EmployeeDto updatedEmployee);

    void deleteEmployee(Long employeeid);

} 