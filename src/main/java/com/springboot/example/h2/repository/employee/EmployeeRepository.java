package com.springboot.example.h2.repository.employee;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.example.h2.model.employee.Employee;

@RepositoryRestResource( collectionResourceRel = "employees", itemResourceRel = "employee", path = "employee")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

}
