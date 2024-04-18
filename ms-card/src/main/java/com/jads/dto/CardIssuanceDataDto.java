package com.jads.dto;

import java.math.BigDecimal;

public class CardIssuanceDataDto {

    private String cardId;
    private String cpf;
    private String address;
    private BigDecimal availableLimit;
    
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BigDecimal getAvailableLimit() {
		return availableLimit;
	}
	public void setAvailableLimit(BigDecimal availableLimit) {
		this.availableLimit = availableLimit;
	}
    
}
