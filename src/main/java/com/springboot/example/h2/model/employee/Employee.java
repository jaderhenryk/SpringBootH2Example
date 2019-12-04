package com.springboot.example.h2.model.employee;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.springboot.example.h2.model.company.Company;

@Entity
@Table(name = "employees", uniqueConstraints = @UniqueConstraint(columnNames = {"name, email"}))
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name")
	@NotNull
	@NotBlank
    private String name;
	@Column(name = "email")
	@NotNull
	@NotBlank
    private String email;
	@Column(name = "role")
    private String role;
	@Column(name = "admissiondate")
	@DateTimeFormat(iso = ISO.DATE)
    private LocalDate admissionDate;
	@Column(name = "salary")
	@Positive
    private double salary;
	@JoinColumn(name = "companyid")
	@NotNull
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Company company;
    
    public Employee() {}
    
    public Employee(String name, String email, Company company) {
        this.name = name;
        this.email = email;
        this.company = company;
    }
    
    public Employee(String name, String email, Company company, String role, double salary, LocalDate admissionDate) {
    	this(name, email, company);
    	this.role = role;
    	this.salary = salary;
    	this.admissionDate = admissionDate;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public LocalDate getAdmissionDate() {
        return admissionDate;
    }
    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
}
