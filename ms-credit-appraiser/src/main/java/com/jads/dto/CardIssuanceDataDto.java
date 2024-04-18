package com.jads.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CardIssuanceDataDto {

	@NotBlank(message = "O card id deve ser informado")
    private String cardId;
	
	@NotBlank(message = "O cpf deve ser informado")
    private String cpf;
	
	@NotBlank(message = "O endereço deve ser informado")
    private String address;
	
	@NotNull(message = "O limite disponível deve ser informado")
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
