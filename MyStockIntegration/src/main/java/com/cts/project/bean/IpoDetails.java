package com.cts.project.bean;

import java.io.Serializable;
import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stockipo")
public class IpoDetails implements Serializable{

	private static final long serialVersionUID = -8144883789755843261L;
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String stckExchange;
	private long pricePerShare;
	private long noOfShares;
	private LocalDate dateTime;
	private String remarks;
	
	public IpoDetails() {
		
	}

	public IpoDetails(Integer id, String name, String stckExchange, long pricePerShare, long noOfShares,
			LocalDate dateTime, String remarks) {
		super();
		this.id = id;
		this.name = name;
		this.stckExchange = stckExchange;
		this.pricePerShare = pricePerShare;
		this.noOfShares = noOfShares;
		this.dateTime = dateTime;
		this.remarks = remarks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStckExchange() {
		return stckExchange;
	}

	public void setStckExchange(String stckExchange) {
		this.stckExchange = stckExchange;
	}

	public long getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(long pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public long getNoOfShares() {
		return noOfShares;
	}

	public void setNoOfShares(long noOfShares) {
		this.noOfShares = noOfShares;
	}

	public LocalDate getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "IpoDetails [id=" + id + ", name=" + name + ", stckExchange=" + stckExchange + ", pricePerShare="
				+ pricePerShare + ", noOfShares=" + noOfShares + ", dateTime=" + dateTime + ", remarks=" + remarks
				+ "]";
	}
	
	
}
