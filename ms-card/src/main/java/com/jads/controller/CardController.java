package com.jads.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jads.controller.payload.CardCustomerResponse;
import com.jads.controller.payload.CardRequest;
import com.jads.controller.payload.CardResponse;
import com.jads.dto.CardCustomerDto;
import com.jads.dto.CardDto;
import com.jads.exception.BodyResponse;
import com.jads.service.CardCustomerService;
import com.jads.service.CardService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("card")
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private CardCustomerService cardCustumerService;
	
	@GetMapping("/status")
	public ResponseEntity<BodyResponse> serviceStatus() {
		BodyResponse response = new BodyResponse("Serviço de cartões ativo!");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CardResponse> saveCard(@RequestBody @Valid CardRequest request){
		CardDto dto = request.toDto();
		dto = cardService.saveCard(dto);
		
		return new ResponseEntity<>(dto.toResponse(), HttpStatus.OK);
	}
	
	 @GetMapping(params = "income")
	 public ResponseEntity<List<CardResponse>> getCardsWithIncomeUpTo(@RequestParam("income") Long income){
		 List<CardDto> dtos = cardService.getIncomeLessThanEqual(income);
		 
			if (dtos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			List<CardResponse> response = dtos.stream()
					.map(dto -> dto.toResponse())
					.collect(Collectors.toList());
		 
		 return new ResponseEntity<>(response, HttpStatus.OK);
	 }
	 
	 @GetMapping(params = "cpf")
	 public ResponseEntity<List<CardCustomerResponse>> getCardsByCustomer(@RequestParam("cpf") String cpf){
		 List<CardCustomerDto> list = cardCustumerService.findByCpf(cpf);
		 
		 if (list.isEmpty()) {
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 }
		 
		 List<CardCustomerResponse> resultList = list.stream()
				 .map(CardCustomerResponse::fromModel)
				 .collect(Collectors.toList());
		 
		 return new ResponseEntity<>(resultList, HttpStatus.OK);
	 }

}
