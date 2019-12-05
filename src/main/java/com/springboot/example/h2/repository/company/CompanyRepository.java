package com.springboot.example.h2.repository.company;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.example.h2.model.company.Company;

@RepositoryRestResource(collectionResourceRel = "companies", itemResourceRel = "company", path = "company")
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {

}
