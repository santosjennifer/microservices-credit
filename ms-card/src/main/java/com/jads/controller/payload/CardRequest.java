package com.jads.controller.payload;

import java.math.BigDecimal;

import com.jads.dto.CardDto;
import com.jads.model.CardBrand;

public class CardRequest {

    private String name;
    private CardBrand brand;
    private BigDecimal income;
    private BigDecimal basicLimit;
    
    public CardDto toDto() {
    	return new CardDto(name, brand, income, basicLimit);
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
