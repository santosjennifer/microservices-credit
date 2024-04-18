package com.jads.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jads.controller.payload.CustomerRequest;
import com.jads.controller.payload.CustomerResponse;
import com.jads.dto.CustomerDto;
import com.jads.exception.BodyResponse;
import com.jads.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/status")
	public ResponseEntity<BodyResponse> serviceStatus(){
		BodyResponse response = new BodyResponse("Serviço de clientes ativo!");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CustomerResponse> createCustomer(@RequestBody @Valid CustomerRequest request){
		CustomerDto dto = request.convertToDto();
		dto = service.create(dto);
		
		return new ResponseEntity<>(dto.convertToResponse(),HttpStatus.OK);
	}
	
	@GetMapping(params = "cpf")
	public ResponseEntity<CustomerResponse> findByCpf(@RequestParam("cpf") String cpf){
		Optional<CustomerDto> dto = service.findByCpf(cpf);
		
		if (dto.isPresent()) {
			return new ResponseEntity<>(dto.get().convertToResponse(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
