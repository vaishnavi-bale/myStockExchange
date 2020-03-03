package com.cts.project.companyservice;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyRepo companyRepo;

	@Override
	public List<Company> getAllCompany() {
		return companyRepo.findAll();
	}

	@Override
	public void deleteById(int id) {
	companyRepo.deleteById(id);
	}

	@Override
	public Company addCompany(Company company) {
		companyRepo.save(company);
		return company;
	}

	@Override
	public Company updateCompany(Company company) {
		companyRepo.save(company);
		return company;
	}

	@Override
	public Company getCompanyById(int id) {
		Optional<Company> company=companyRepo.findById(id);
		return company.orElse(null);
	}

}
