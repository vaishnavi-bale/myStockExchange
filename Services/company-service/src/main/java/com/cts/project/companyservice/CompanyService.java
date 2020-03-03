package com.cts.project.companyservice;

import java.util.List;

public interface CompanyService {

	public List<Company> getAllCompany();
	
	public Company addCompany(Company company);
	
	public Company updateCompany(Company company);
	
	public void deleteById(int id);
	
	public Company getCompanyById(int id);
}
