package com.cts.project.stockpriceservice;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="stockprice")
public class StockPrice implements Serializable {

	private static final long serialVersionUID = 4361765948952898725L;
	@Id
	@GeneratedValue
	private Integer id;
	private String companyCode;
	private String stockExchange;
	private long currentPrice;
	private LocalDate date;
	private LocalTime time;

	 public StockPrice() {
	}

	

	public StockPrice(Integer id, String companyCode, String stockExchange, long currentPrice, LocalDate date,
			LocalTime time) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.stockExchange = stockExchange;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
	}

    

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getCompanyCode() {
		return companyCode;
	}



	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}



	public long getCurrentPrice() {
		return currentPrice;
	}



	public void setCurrentPrice(long currentPrice) {
		this.currentPrice = currentPrice;
	}



	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "StockPrice [companyCode=" + companyCode + ", stockExchange=" + stockExchange + ", currentPrice="
				+ currentPrice + ", date=" + date + ", time=" + time + "]";
	}

	
	
}
