package com.example.ems_backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ems_backend.dto.EmployeeDto;
import com.example.ems_backend.entity.Employee;
import com.example.ems_backend.exceptions.ResourceNotFoundException;
import com.example.ems_backend.mapper.EmployeeMapper;
import com.example.ems_backend.repository.EmployeeRepository;
import com.example.ems_backend.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository ;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee) ;
    }

    @Override
    public EmployeeDto gEmployeeById(Long employeeID) {
        Employee employee =employeeRepository.findById(employeeID)
        .orElseThrow(() -> 
                new ResourceNotFoundException("Employee is not exists with the given id :" + employeeID));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect((Collectors.toList()));
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeid, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById((employeeid)).orElseThrow(
            () -> new ResourceNotFoundException(("Employee not exists with the given id :" + employeeid))
        );
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updateEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updateEmployeeObj);
    }

    

}
