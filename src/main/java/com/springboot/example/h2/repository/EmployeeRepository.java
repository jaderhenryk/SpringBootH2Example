package com.springboot.example.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.example.h2.model.employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
