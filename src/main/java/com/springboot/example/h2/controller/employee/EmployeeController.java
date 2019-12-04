package com.springboot.example.h2.controller.employee;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.example.h2.exception.ResourceNotFoundException;
import com.springboot.example.h2.model.employee.Employee;
import com.springboot.example.h2.repository.employee.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @GetMapping
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> findById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id ::" + id));
        return ResponseEntity.ok(employee);
    }
    
    @PostMapping
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeRepository.save(employee));
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<Employee> update(
            @PathVariable(name = "id") Long id,
            @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id ::" + id));
        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setRole(employeeDetails.getRole());
        employee.setSalary(employeeDetails.getSalary());
        employee.setAdmissionDate(employeeDetails.getAdmissionDate());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id ::" + id));
        employeeRepository.deleteById(id);
        return ResponseEntity.ok("Deleted!");
    }
}
