package com.cts.project.stockexchangeservice;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class StockExchangeController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StockExchangeService stockService;
	
	@PostMapping("/stockexchange")
	public ResponseEntity<?> saveCompany(@RequestBody StockExchange stock){
		stockService.addStockExchange(stock);
		return new ResponseEntity<StockExchange>(stock, HttpStatus.CREATED);
	}
	
	@PutMapping("/stockexchange")
	public ResponseEntity<?> updateCompany(@RequestBody StockExchange stock){
		stockService.updateStockExchange(stock);
		return new ResponseEntity<StockExchange>(stock, HttpStatus.CREATED);
	}
	
	@GetMapping("/stockexchange/{id}")
	public ResponseEntity<?> getStockExchangeWithId(@PathVariable int id){
		StockExchange stock=stockService.getStockExchangeById(id);
		if(stock!=null) {
			return new ResponseEntity<StockExchange>(stock, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("No StockExchange with Speciefied Id", HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/stockexchange/{id}")
	public void deleteStockExchange(@PathVariable int id) {
		stockService.deleteStockExchange(id);
	}
	
	@GetMapping("/stockexchange")
	public ResponseEntity<?> getStockExchanges(){
		List<StockExchange> stocklist=stockService.getAllStockExchange();
		if(stocklist.size()>0) {
			return new ResponseEntity<List<StockExchange>>(stocklist, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("No items in the list", HttpStatus.NOT_FOUND);
		}
	}

//	@Autowired
//	StockExchangeRepo stockRepo;
//	
//	@GetMapping("/stockexchange")
//	public List<StockExchange> getAllStocks(){
//		return stockRepo.findAll();
//	}
//	
//	@GetMapping("/stockexchange/{id}")
//	public StockExchange getStockById(@PathVariable int id) {
//		Optional<StockExchange> stocklist=stockRepo.findById(id);
//		StockExchange stock=stocklist.get();
//		return stock;
//	}
//	
//	@PostMapping("/stockexchange")
//	public StockExchange saveStock(@RequestBody StockExchange stock) {
//		StockExchange newStock=stockRepo.save(stock);
//		return newStock;
//	}
//	
//	@DeleteMapping("/stockexchange/{id}")
//	public void deleteStock(@PathVariable int id) {
//		stockRepo.deleteById(id);
//	}
//	
//	@PutMapping("/stockexchange")
//	public StockExchange updateStock(@RequestBody StockExchange stock) {
//		StockExchange updateStock=stockRepo.save(stock);
//		return updateStock;
//	}
}
