package com.cts.project.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.bean.Company;
import com.cts.project.dao.CompanyDAO;

@RestController
@CrossOrigin(origins = "*")
public class CompanyDAOImpl {

	@Autowired
	CompanyDAO companyDAO;
	
	@GetMapping("/company")
	public List<Company> getCompany(){
		return companyDAO.findAll();
	}
	
	@GetMapping("/company/{id}")
	public Company getCompanyById(@PathVariable int id) {
		Optional<Company> companyList=companyDAO.findById(id);
		Company company=companyList.get();
		return company;
	}
	
	@PostMapping("/company")
	public Company saveCompany(@RequestBody Company company) {
		Company newCompany=companyDAO.save(company);
		return newCompany;
	}
	
	@DeleteMapping("/company/{id}")
	public void deleteCompany(@PathVariable int id) {
		companyDAO.deleteById(id);
	}
	
	@PutMapping("/company/")
	public Company updateCompany(@RequestBody Company company) {
		Company updateCompany=companyDAO.save(company);
		return updateCompany;
	}
	
}
