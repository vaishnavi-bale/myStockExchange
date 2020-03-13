package com.cts.project.stockpriceservice;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface StockPriceService {

	public StockPrice saveStockPrice(StockPrice stockPrice);
	
	public StockPrice updateStockPrice(StockPrice stockPrice);
	
	public void deleteStockPrice(int id);
	
	public List<StockPrice> getAllStockPrice();
	
	public StockPrice getStockPriceById(int id);
	
	public ImportSummary addStockPricesFromExcelSheet(MultipartFile file) throws Exception;

	List<StockPriceOnPeriod> getCompanyStockPriceBetween(String companyCode, String stockExchange, LocalDate startDate,
			LocalDate endDate);
}
