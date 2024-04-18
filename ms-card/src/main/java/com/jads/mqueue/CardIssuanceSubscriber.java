package com.jads.mqueue;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jads.dto.CardIssuanceDataDto;
import com.jads.model.Card;
import com.jads.model.CardCustomer;
import com.jads.repository.CardCustomerRepository;
import com.jads.repository.CardRepository;

@Component
public class CardIssuanceSubscriber {
	
	private static final Logger log = LoggerFactory.getLogger(CardIssuanceSubscriber.class);
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private CardCustomerRepository cardCustomerRepository;
	
	@RabbitListener(queues = "${mq.queues.card-issuance}")
	public void receiveIssuanceRequest(@Payload String payload) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			CardIssuanceDataDto data = mapper.readValue(payload, CardIssuanceDataDto.class);
			Optional<Card> card = cardRepository.findById(data.getCardId());
			
			if (card.isPresent()) {
				CardCustomer cardCustomer = new CardCustomer();
				cardCustomer.setCard(card.get());
				cardCustomer.setCpf(data.getCpf());
				cardCustomer.setLimit(data.getAvailableLimit());
			
				cardCustomerRepository.save(cardCustomer);
			
			} else {
				log.error("Cartão não encontrado para o ID: {}", data.getCardId());
			}
	    } catch (Exception e) {
			log.error("Erro ao receber solicitacao de emissao de cartao: {} ", e.getMessage());
		}
	}

}
