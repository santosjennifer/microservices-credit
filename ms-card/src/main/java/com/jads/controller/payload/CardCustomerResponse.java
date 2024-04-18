package com.jads.controller.payload;

import java.math.BigDecimal;

import com.jads.dto.CardCustomerDto;

public class CardCustomerResponse {
	
	private String name;
	private String brand;
	private BigDecimal availableLimit;
	
	public static CardCustomerResponse fromModel(CardCustomerDto dto) {
		return new CardCustomerResponse (
				dto.getCard().getName(),
				dto.getCard().getBrand().toString(),
				dto.getLimit()
		);
	}
	
	public CardCustomerResponse(String name, String brand, BigDecimal availableLimit) {
		this.name = name;
		this.brand = brand;
		this.availableLimit = availableLimit;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public BigDecimal getAvailableLimit() {
		return availableLimit;
	}
	public void setAvailableLimit(BigDecimal availableLimit) {
		this.availableLimit = availableLimit;
	}
	  
}
