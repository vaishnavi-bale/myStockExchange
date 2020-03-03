package com.cts.project.stockpriceservice;

import java.util.List;

public interface StockPriceService {

	public StockPrice saveStockPrice(StockPrice stockPrice);
	
	public StockPrice updateStockPrice(StockPrice stockPrice);
	
	public void deleteStockPrice(int id);
	
	public List<StockPrice> getAllStockPrice();
	
	public StockPrice getStockPriceById(int id);
}
