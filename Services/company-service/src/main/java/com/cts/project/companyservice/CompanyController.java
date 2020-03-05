package com.cts.project.companyservice;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class CompanyController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CompanyService companyService;
	
	@GetMapping("/company")
	public ResponseEntity<?> getAllCompanies(){
		List<Company> company=companyService.getAllCompany();
		if(company.size()>0) {
			return new ResponseEntity<List<Company>>(company, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("No Companies in the list", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/company")
	public ResponseEntity<?> saveCompany(@RequestBody Company company){
		companyService.addCompany(company);
		return new ResponseEntity<Company>(company, HttpStatus.CREATED);
	}
	
	@PutMapping("/company")
	public ResponseEntity<?> updateCompany(@RequestBody Company company){
		companyService.updateCompany(company);
		return new ResponseEntity<Company>(company,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/company/{id}")
	public void deleteCompany(@PathVariable int id) {
		 companyService.deleteById(id);
	}
	
	@GetMapping("/company/{id}")
	public ResponseEntity<?> getCompanyWithId(@PathVariable int id){
		Company company=companyService.getCompanyById(id);
		if(company!=null) {
			return new ResponseEntity<Company>(company, HttpStatus.OK);
		}else {
		return new ResponseEntity<String>("No such Id", HttpStatus.NOT_FOUND);
		}
	}
	
//	@Autowired
//	CompanyRepo companyRepo;
//	
//	@GetMapping("/company")
//	public List<Company> getCompany(){
//		return companyRepo.findAll();
//	}
//	
//	@GetMapping("/company/{id}")
//	public Company getCompanyById(@PathVariable int id) {
//		Optional<Company> companyList=companyRepo.findById(id);
//		Company company=companyList.get();
//		return company;
//	}
//	
//	@PostMapping("/company")
//	public Company saveCompany(@RequestBody Company company) {
//		Company newCompany=companyRepo.save(company);
//		return newCompany;
//	}
//	
//	@DeleteMapping("/company/{id}")
//	public void deleteCompany(@PathVariable int id) {
//		companyRepo.deleteById(id);
//	}
//	
//	@PutMapping("/company/")
//	public Company updateCompany(@RequestBody Company company) {
//		Company updateCompany=companyRepo.save(company);
//		return updateCompany;
//	}
	
	
}
