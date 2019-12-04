package com.springboot.example.h2.model.base.employee;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.springboot.example.h2.model.base.BaseModel;

@Entity
@Table(name = "employees")
public class Employee extends BaseModel {

    private String name;
    private String email;
    private String role;
    private LocalDate admissionDate;
    private double salary;
    
    public Employee() {}
    
    public Employee(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }
    
    @Column(name = "name")
    @NotNull
    @NotBlank
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "email")
    @NotNull
    @NotBlank
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "role")
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    @Column(name = "admissionDate")
    public LocalDate getAdmissionDate() {
        return admissionDate;
    }
    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }
    @Column(name = "salary")
    @Positive
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
