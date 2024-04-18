package com.jads.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {
	
	@Value("${mq.queues.card-issuance}")
	private String cardIssuanceQueue;
	
	@Bean
	public Queue queueCardIssuance() {
		return new Queue(cardIssuanceQueue, true);
	}

}
