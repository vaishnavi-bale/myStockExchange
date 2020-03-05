package com.cts.project.stockpriceservice;

import java.util.List;

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
public class StockPriceController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StockPriceService stockPriceService;
	
	@PostMapping("/stockprice")
	public ResponseEntity<?> addStockPrice(@RequestBody StockPrice stockPrice) {
		stockPriceService.saveStockPrice(stockPrice);
		return new ResponseEntity<StockPrice>(stockPrice, HttpStatus.CREATED);
	}	
	
	@PutMapping("/stockprice")
	public  ResponseEntity<?> updateStockPrices(@RequestBody StockPrice stockPrice){
		stockPriceService.updateStockPrice(stockPrice);
		return new ResponseEntity<StockPrice>(stockPrice, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/stockprice/{id}")
	public void deleteStockPrices(@PathVariable int id) {
		stockPriceService.deleteStockPrice(id);
	}
	
	@GetMapping("/stockprice")
	public ResponseEntity<?> getAllPrices(){
		List<StockPrice> stocklist=stockPriceService.getAllStockPrice();
		if(stocklist.size()>0) {
			return new ResponseEntity<List<StockPrice>>(stocklist, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("No items in the list", HttpStatus.NOT_FOUND);
		}
	}
	
}
