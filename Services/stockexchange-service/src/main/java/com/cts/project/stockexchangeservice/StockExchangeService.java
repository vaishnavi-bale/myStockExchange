package com.cts.project.stockexchangeservice;

import java.util.List;

public interface StockExchangeService {

	public StockExchange addStockExchange(StockExchange stock);
	
	public StockExchange updateStockExchange(StockExchange stock);
	
	public void deleteStockExchange(int id);
	
	public StockExchange getStockExchangeById(int id);
	
	public List<StockExchange> getAllStockExchange();
}
