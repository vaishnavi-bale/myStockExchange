package com.cts.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.bean.StockExchange;
import com.cts.project.repo.StockExchangeRepo;

@RestController
@CrossOrigin(origins = "*")
public class StockExchangeController {

	@Autowired
	StockExchangeRepo stockRepo;
	
	@GetMapping("/stockexchange")
	public List<StockExchange> getAllStocks(){
		return stockRepo.findAll();
	}
	
	@GetMapping("/stockexchange/{id}")
	public StockExchange getStockById(@PathVariable int id) {
		Optional<StockExchange> stocklist=stockRepo.findById(id);
		StockExchange stock=stocklist.get();
		return stock;
	}
	
	@PostMapping("/stockexchange")
	public StockExchange saveStock(@RequestBody StockExchange stock) {
		StockExchange newStock=stockRepo.save(stock);
		return newStock;
	}
	
	@DeleteMapping("/stockexchange/{id}")
	public void deleteStock(@PathVariable int id) {
		stockRepo.deleteById(id);
	}
	
	@PutMapping("/stockexchange")
	public StockExchange updateStock(@RequestBody StockExchange stock) {
		StockExchange updateStock=stockRepo.save(stock);
		return updateStock;
	}
}
