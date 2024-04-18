package com.jads.dto;

import java.math.BigDecimal;

public class CardDto {
	
    private String id;
    private String name;
    private String brand;
    private BigDecimal basicLimit;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public BigDecimal getBasicLimit() {
		return basicLimit;
	}
	public void setBasicLimit(BigDecimal basicLimit) {
		this.basicLimit = basicLimit;
	}

}
