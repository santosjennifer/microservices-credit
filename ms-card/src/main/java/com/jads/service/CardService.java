package com.jads.service;

import java.util.List;

import com.jads.dto.CardDto;

public interface CardService {

	CardDto saveCard(CardDto cardDto);
	List<CardDto> getIncomeLessThanEqual(Long income);
	
}
