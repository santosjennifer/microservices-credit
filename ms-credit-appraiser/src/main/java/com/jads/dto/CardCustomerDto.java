package com.jads.dto;

import java.math.BigDecimal;

public class CardCustomerDto {

    private String name;
    private String brand;
    private BigDecimal availableLimit;
    
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
