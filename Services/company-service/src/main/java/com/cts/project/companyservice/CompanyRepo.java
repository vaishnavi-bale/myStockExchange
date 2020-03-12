package com.cts.project.companyservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Integer>{

	public List<Company> findAllByCompanyNameContaining(String pattern);
	
	public Company findByCompanyName(String companyName);
}
