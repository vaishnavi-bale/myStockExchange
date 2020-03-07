package com.cts.project.stockpriceservice;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StockPriceRepo extends JpaRepository<StockPrice, Integer>{
	
	@Query("From StockPrice where companyCode=?1 and stockExchange=?2 and date=?3 and time=?4")
	public Optional<StockPrice> getIfAlreadyExists(String comanyCode,String stockExchange,LocalDate date,LocalTime time);

}
