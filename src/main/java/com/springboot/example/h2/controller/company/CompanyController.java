package com.springboot.example.h2.controller.company;

import java.util.List;

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
import com.springboot.example.h2.model.company.Company;
import com.springboot.example.h2.repository.company.CompanyRepository;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;
	
	@GetMapping
	public List<Company> findAll() {
		return companyRepository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Company> findById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
		Company company = companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id ::" + id));
		return ResponseEntity.ok(company);
	}
	
	@PostMapping
	public ResponseEntity<Company> create(@RequestBody Company company) {
		return ResponseEntity.ok(companyRepository.save(company));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Company> update(
			@PathVariable(name = "id") Long id, 
			@RequestBody Company companyDetails
			) throws ResourceNotFoundException {
		Company company = companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id ::" + id));
		company.setCompanyAttributes(companyDetails);
		final Company companyUpdated = companyRepository.save(company);
		return ResponseEntity.ok(companyUpdated);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
		companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id ::" + id));
		companyRepository.deleteById(id);
		return ResponseEntity.ok("Deleted successfully!");
	}
}
