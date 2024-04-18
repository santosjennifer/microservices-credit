package com.jads.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jads.dto.CardCustomerDto;
import com.jads.model.CardCustomer;
import com.jads.repository.CardCustomerRepository;
import com.jads.service.CardCustomerService;

@Service
public class CardCustomerServiceImpl implements CardCustomerService {
	
	@Autowired
	private CardCustomerRepository repository;

	@Override
	public List<CardCustomerDto> findByCpf(String cpf) {
		List<CardCustomer> cardsCustomer = repository.findByCpf(cpf);
		
		return cardsCustomer.stream()
				.map(entity -> {
					CardCustomerDto dto = new CardCustomerDto();
					dto.setId(entity.getId());
					dto.setCard(entity.getCard());
					dto.setCpf(entity.getCpf());
					dto.setLimit(entity.getLimit());
					
					return dto;
				})
				.collect(Collectors.toList());
		
	}
	
}
