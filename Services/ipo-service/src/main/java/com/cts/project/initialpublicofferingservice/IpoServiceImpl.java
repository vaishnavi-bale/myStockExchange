package com.cts.project.initialpublicofferingservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpoServiceImpl implements IpoService{

	@Autowired
	IpoDetailsRepo ipoRepo;
	
	@Override
	public IpoDetails saveIpo(IpoDetails ipo) {
		ipoRepo.save(ipo);
		return ipo;
	}

	@Override
	public IpoDetails updateIpo(IpoDetails ipo) {
		ipoRepo.save(ipo);
		return ipo;

	}

	@Override
	public void deleteIpo(int id) {
        ipoRepo.deleteById(id);		
	}

	@Override
	public List<IpoDetails> getAllIpo() {
		return ipoRepo.findAll();
	}

	@Override
	public IpoDetails getIpoById(int id) {
		Optional<IpoDetails> ipo=ipoRepo.findById(id);
		return ipo.orElse(null);
	}

	
}
