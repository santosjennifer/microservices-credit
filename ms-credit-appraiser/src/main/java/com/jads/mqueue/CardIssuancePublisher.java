package com.jads.mqueue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jads.dto.CardIssuanceDataDto;

@Component
public class CardIssuancePublisher {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private Queue queueCardIssuance;
	
	public void requestCard(CardIssuanceDataDto data) throws JsonProcessingException {
		String json = convertIntoJson(data);
		rabbitTemplate.convertAndSend(queueCardIssuance.getName(), json);
	}

	private String convertIntoJson(CardIssuanceDataDto data) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(data);
		return json;
	}
}
