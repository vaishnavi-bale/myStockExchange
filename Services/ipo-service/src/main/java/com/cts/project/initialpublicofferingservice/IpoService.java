package com.cts.project.initialpublicofferingservice;

import java.util.List;

public interface IpoService {

	public IpoDetails saveIpo(IpoDetails ipo);
	
	public IpoDetails updateIpo(IpoDetails ipo);
	
	public void deleteIpo(int id);
	
	public List<IpoDetails> getAllIpo();
	
	public IpoDetails getIpoById(int id);
}
