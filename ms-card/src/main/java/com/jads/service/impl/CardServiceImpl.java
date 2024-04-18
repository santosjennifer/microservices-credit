package com.jads.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jads.dto.CardDto;
import com.jads.model.Card;
import com.jads.repository.CardRepository;
import com.jads.service.CardService;

import jakarta.transaction.Transactional;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardRepository repository;
	
	@Override
	@Transactional
	public CardDto saveCard(CardDto cardDto) {
		Card card = new Card();
		card.setName(cardDto.getName());
		card.setBrand(cardDto.getBrand());
		card.setBasicLimit(cardDto.getBasicLimit());
		card.setIncome(cardDto.getIncome());
		card = repository.save(card);

		return convertEntityToDto(card);
	}

	@Override
	public List<CardDto> getIncomeLessThanEqual(Long income) {
		BigDecimal incomeBD = BigDecimal.valueOf(income);
		List<Card> cards = repository.findByIncomeLessThanEqual(incomeBD);
		
		return cards.stream()
				.map(card -> convertEntityToDto(card))
				.collect(Collectors.toList());
	}
	
	private CardDto convertEntityToDto(Card card) {
		CardDto dto = new CardDto();
		dto.setId(card.getId());
		dto.setName(card.getName());
		dto.setBrand(card.getBrand());
		dto.setBasicLimit(card.getBasicLimit());
		dto.setIncome(card.getIncome());
		
		return dto;
	}

}
