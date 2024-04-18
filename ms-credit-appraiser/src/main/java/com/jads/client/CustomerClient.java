package com.jads.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jads.dto.CustomerDto;

@FeignClient(value = "ms-customer", path = "/customer")
public interface CustomerClient {

	@GetMapping(params = "cpf")
	ResponseEntity<CustomerDto> findByCpf(@RequestParam("cpf") String cpf);
	
}
