package com.cts.project.stockexchangeservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockExchangeServiceImpl implements StockExchangeService{

	@Autowired
	StockExchangeRepo stockRepo;
	
	@Override
	public StockExchange addStockExchange(StockExchange stock) {
		stockRepo.save(stock);
		return stock;
	}

	@Override
	public StockExchange updateStockExchange(StockExchange stock) {
		stockRepo.save(stock);
		return stock;
	}

	@Override
	public void deleteStockExchange(int id) {
		stockRepo.deleteById(id);
	}

	@Override
	public StockExchange getStockExchangeById(int id) {
		Optional<StockExchange> stockExchange=stockRepo.findById(id);
		return stockExchange.orElse(null);
	}

	@Override
	public List<StockExchange> getAllStockExchange() {
		return stockRepo.findAll();
	}

}
