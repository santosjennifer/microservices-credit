package com.jads.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jads.controller.payload.AssessmentDataRequest;
import com.jads.dto.CardIssuanceDataDto;
import com.jads.dto.CardRequestProtocolDto;
import com.jads.dto.ReturnCustomerReviewDto;
import com.jads.dto.StatusCustomerDto;
import com.jads.exception.BodyResponse;
import com.jads.service.CreditAppraiserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("credit-appraiser")
public class CreditAppraiserController {

	@Autowired
	private CreditAppraiserService service;

	@GetMapping("/status")
	public ResponseEntity<BodyResponse> serviceStatus() {
		BodyResponse response = new BodyResponse("Serviço de avaliação de crédito ativo!");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "customer-status", params = "cpf")
	public ResponseEntity<StatusCustomerDto> getStatusCustomer(@RequestParam("cpf") String cpf) {
		StatusCustomerDto statusCustomer = service.getStatusCustomer(cpf);

		return new ResponseEntity<>(statusCustomer, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ReturnCustomerReviewDto> doAssessment(@RequestBody @Valid AssessmentDataRequest request) {
		ReturnCustomerReviewDto returnCustomerReview = service.doAssessment(request.getCpf(), request.getIncome());

		return new ResponseEntity<>(returnCustomerReview, HttpStatus.OK);
	}
	
    @PostMapping("card-requests")
    public ResponseEntity<CardRequestProtocolDto> requestCard(@RequestBody @Valid CardIssuanceDataDto request){
    	CardRequestProtocolDto cardRequestProtocol = service.requestCardIssuance(request);
    	
        return new ResponseEntity<>(cardRequestProtocol, HttpStatus.OK);
    }

}
