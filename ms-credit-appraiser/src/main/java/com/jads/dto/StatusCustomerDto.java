package com.jads.dto;

import java.util.List;

public class StatusCustomerDto {
	
    private CustomerDto customer;
    private List<CardCustomerDto> cards;
    
	public StatusCustomerDto(CustomerDto customer, List<CardCustomerDto> cards) {
		this.customer = customer;
		this.cards = cards;
	}
	public CustomerDto getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}
	public List<CardCustomerDto> getCards() {
		return cards;
	}
	public void setCards(List<CardCustomerDto> cards) {
		this.cards = cards;
	}

}
