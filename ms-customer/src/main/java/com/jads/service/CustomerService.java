package com.jads.service;

import java.util.Optional;

import com.jads.dto.CustomerDto;

public interface CustomerService {

	Optional<CustomerDto> findByCpf(String cpf);
	CustomerDto create(CustomerDto customerDto);
	
}
