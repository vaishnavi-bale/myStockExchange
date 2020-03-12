package com.cts.project.stockpriceservice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	@PostMapping(value="stockprices/uploadStockSheet",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> uploadStockSheet(@RequestParam("stocksSheet") MultipartFile file){
		logger.info("File received: {}",file.getOriginalFilename());
		if(file.getOriginalFilename().endsWith(".xls")|| file.getOriginalFilename().endsWith(".xlsx")) {
			try {
				return new ResponseEntity<ImportSummary>(stockPriceService.addStockPricesFromExcelSheet(file), HttpStatus.OK);
			} catch (IOException e) {
				e.printStackTrace();
				return new ResponseEntity<String>("Error Reading File", HttpStatus.BAD_REQUEST);
			} catch(Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<String>("Wrong file extension. The file should be .xls or an .xlsx file.", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/stockPrices/companyStockPriceBetween/{companyCode}/{stockExchange}/{startDate}/{endDate}/{periodicity}", 
			produces = "application/json")
	public ResponseEntity<?> getCompanyStockPricePerDayBetween(@PathVariable String companyCode,
			@PathVariable String stockExchange, @PathVariable String startDate, @PathVariable String endDate,
			@PathVariable String periodicity) {
		return new ResponseEntity<List<StockPriceOnPeriod>>(stockPriceService.getCompanyStockPriceBetween(companyCode,
				stockExchange, LocalDate.parse(startDate), LocalDate.parse(endDate), periodicity), HttpStatus.OK);
	}
}
