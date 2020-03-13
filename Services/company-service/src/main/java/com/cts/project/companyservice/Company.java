package com.cts.project.companyservice;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stockcompany")
public class Company implements Serializable{
	
	private static final long serialVersionUID = 7946065738947041340L;
	@Id
	@GeneratedValue
	private Integer id;
	private String companyName;
	private String ceoName;
	private String boardMember;
	
	private String[] listed_in_stock_exchanges;
	private String sector;
	private int turnOver;
	private String briefDescription;
	private String code;
	
	public Company() {
		
	}
	public Company(Integer id, String companyName, String ceoName, String boardMember,
			String[] listed_in_stock_exchanges, String sector, int turnOver, String briefDescription,
			String code) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.ceoName = ceoName;
		this.boardMember = boardMember;
		this.listed_in_stock_exchanges = listed_in_stock_exchanges;
		this.sector = sector;
		this.turnOver = turnOver;
		this.briefDescription = briefDescription;
		this.code = code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCeoName() {
		return ceoName;
	}

	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}

	public String getBoardMember() {
		return boardMember;
	}

	public void setBoardMember(String boardMember) {
		this.boardMember = boardMember;
	}

	public int getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(int turnOver) {
		this.turnOver = turnOver;
	}

	public String getBriefDescription() {
		return briefDescription;
	}

	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}


	public String[] getListed_in_stock_exchanges() {
		return listed_in_stock_exchanges;
	}

	public void setListed_in_stock_exchanges(String[] listed_in_stock_exchanges) {
		this.listed_in_stock_exchanges = listed_in_stock_exchanges;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", ceoName=" + ceoName + ", boardMember="
				+ boardMember + ", listed_in_stock_exchanges=" + listed_in_stock_exchanges + ", sector=" + sector
				+ ", turnOver=" + turnOver + ", briefDescription=" + briefDescription + ", code=" + code
				+ "]";
	}



	
}
