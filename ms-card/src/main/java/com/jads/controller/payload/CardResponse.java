package com.jads.controller.payload;

import java.math.BigDecimal;

import com.jads.model.CardBrand;

public class CardResponse {

    private String id;
    private String name;
    private CardBrand brand;
    private BigDecimal income;
    private BigDecimal basicLimit;

	public CardResponse(String id, String name, CardBrand brand, BigDecimal income, BigDecimal basicLimit) {
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.income = income;
		this.basicLimit = basicLimit;
	}
	
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
	public CardBrand getBrand() {
		return brand;
	}
	public void setBrand(CardBrand brand) {
		this.brand = brand;
	}
	public BigDecimal getIncome() {
		return income;
	}
	public void setIncome(BigDecimal income) {
		this.income = income;
	}
	public BigDecimal getBasicLimit() {
		return basicLimit;
	}
	public void setBasicLimit(BigDecimal basicLimit) {
		this.basicLimit = basicLimit;
	}
    
}
