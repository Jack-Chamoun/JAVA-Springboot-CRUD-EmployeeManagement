package com.example.ems_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ems_backend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{/*the arguments are the Entity and the type of Primary key,in this case it is Employee,long */


    
}