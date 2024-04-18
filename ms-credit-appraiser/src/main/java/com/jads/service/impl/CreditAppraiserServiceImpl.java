package com.jads.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jads.client.CardClient;
import com.jads.client.CustomerClient;
import com.jads.dto.ApprovedCardDto;
import com.jads.dto.CardCustomerDto;
import com.jads.dto.CardDto;
import com.jads.dto.CardIssuanceDataDto;
import com.jads.dto.CardRequestProtocolDto;
import com.jads.dto.CustomerDto;
import com.jads.dto.ReturnCustomerReviewDto;
import com.jads.dto.StatusCustomerDto;
import com.jads.exception.CardIssuanceException;
import com.jads.exception.CustomerNotFoundException;
import com.jads.mqueue.CardIssuancePublisher;
import com.jads.service.CreditAppraiserService;

@Service
public class CreditAppraiserServiceImpl implements CreditAppraiserService {

	@Autowired
	private CardIssuancePublisher cardIssuancePublisher;

	@Autowired
	private CustomerClient customerClient;

	@Autowired
	private CardClient cardClient;

	@Override
	public StatusCustomerDto getStatusCustomer(String cpf) {
		ResponseEntity<CustomerDto> customerData = customerClient.findByCpf(cpf);
		ResponseEntity<List<CardCustomerDto>> cards = cardClient.getCardsByCustomer(cpf);
		
	    CustomerDto customerDto = customerData.getBody();
	    List<CardCustomerDto> cardList = cards.getBody();
	    
	    if (customerDto == null) {
	        throw new CustomerNotFoundException();
	    }
		
		if (cardList == null) {
			cardList = Collections.emptyList();
		}

		StatusCustomerDto statusCustomer = new StatusCustomerDto(customerDto, cardList);

		return statusCustomer;
	}

	@Override
	public ReturnCustomerReviewDto doAssessment(String cpf, Long income) {
		ResponseEntity<CustomerDto> customerData = customerClient.findByCpf(cpf);
		ResponseEntity<List<CardDto>> cardsData = cardClient.getCardsWithIncomeUpTo(income);
			
		CustomerDto customerDto = customerData.getBody();
		List<CardDto> cardList = cardsData.getBody();
			
		if (customerDto == null) {
		   throw new CustomerNotFoundException();
		}
			
		if (cardList == null) {
			cardList = Collections.emptyList();
		}
			
		List<ApprovedCardDto> approvedCardsList = cardList.stream().map(card -> {
			BigDecimal basicLimit = card.getBasicLimit();
			BigDecimal ageBD = BigDecimal.valueOf(customerDto.getAge());
			BigDecimal fator = ageBD.divide(BigDecimal.valueOf(10));
			BigDecimal approvedLimit = fator.multiply(basicLimit);

			ApprovedCardDto approved = new ApprovedCardDto();
			approved.setCard(card.getName());
			approved.setBrand(card.getBrand());
			approved.setApprovedLimit(approvedLimit);

			return approved;

		}).collect(Collectors.toList());

		return new ReturnCustomerReviewDto(approvedCardsList);
	}

	@Override
	public CardRequestProtocolDto requestCardIssuance(CardIssuanceDataDto data) {
		try {
			cardIssuancePublisher.requestCard(data);
			String protocol = UUID.randomUUID().toString();

			return new CardRequestProtocolDto(protocol);
		} catch (Exception e) {
	        throw new CardIssuanceException("Erro ao processar a solicitação do cartão: " + e.getMessage());
	    }
	}

}
