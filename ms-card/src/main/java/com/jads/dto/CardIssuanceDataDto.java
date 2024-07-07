package com.jads.dto;

import java.math.BigDecimal;

public class CardIssuanceDataDto {

    private Long cardId;
    private String cpf;
    private String address;
    private BigDecimal availableLimit;
    
	public Long getCardId() {
		return cardId;
	}
	public void setCardId(Long cardId) {
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
