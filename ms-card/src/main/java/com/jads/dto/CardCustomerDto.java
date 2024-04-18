package com.jads.dto;

import java.math.BigDecimal;

import com.jads.model.Card;

public class CardCustomerDto {

    private String id;
    private String cpf;
    private Card card;
    private BigDecimal limit;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public BigDecimal getLimit() {
		return limit;
	}
	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}
    
}
