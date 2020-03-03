package com.cts.project.stockpriceservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StockPriceServiceImpl implements StockPriceService{

	@Autowired
	StockPriceRepo stockPriceRepo;
	
	@Override
	public StockPrice saveStockPrice(StockPrice stockPrice) {
		stockPriceRepo.save(stockPrice);
		return stockPrice;
	}

	@Override
	public StockPrice updateStockPrice(StockPrice stockPrice) {
		stockPriceRepo.save(stockPrice);
		return stockPrice;
	}

	@Override
	public void deleteStockPrice(int id) {
        stockPriceRepo.deleteById(id);
	}

	@Override
	public List<StockPrice> getAllStockPrice() {
		return stockPriceRepo.findAll();
	}

	@Override
	public StockPrice getStockPriceById(int id) {
		Optional<StockPrice> stockprice = stockPriceRepo.findById(id);
		return stockprice.orElse(null);
	}

}
