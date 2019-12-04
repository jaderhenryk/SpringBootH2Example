package com.springboot.example.h2.repository.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.example.h2.model.company.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

}
