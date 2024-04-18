package com.jads.dto;

import java.util.List;

public class ReturnCustomerReviewDto {
	
	private List<ApprovedCardDto> cards;

	public ReturnCustomerReviewDto(List<ApprovedCardDto> cards) {
		this.cards = cards;
	}

	public List<ApprovedCardDto> getCards() {
		return cards;
	}

	public void setCards(List<ApprovedCardDto> cards) {
		this.cards = cards;
	}
	 
}
