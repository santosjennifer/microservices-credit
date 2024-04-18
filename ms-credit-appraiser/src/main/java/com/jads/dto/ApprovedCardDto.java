package com.jads.dto;

import java.math.BigDecimal;

public class ApprovedCardDto {

    private String card;
    private String brand;
    private BigDecimal ApprovedLimit;
    
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public BigDecimal getApprovedLimit() {
		return ApprovedLimit;
	}
	public void setApprovedLimit(BigDecimal approvedLimit) {
		ApprovedLimit = approvedLimit;
	}
    
}
