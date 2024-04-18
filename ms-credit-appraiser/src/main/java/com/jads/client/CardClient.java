package com.jads.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jads.dto.CardCustomerDto;
import com.jads.dto.CardDto;

@FeignClient(value = "ms-card", path = "/card")
public interface CardClient {

	@GetMapping(params = "cpf")
	ResponseEntity<List<CardCustomerDto>> getCardsByCustomer(@RequestParam("cpf") String cpf);
	
	@GetMapping(params = "income")
	ResponseEntity<List<CardDto>> getCardsWithIncomeUpTo(@RequestParam("income") Long income);
	
}
