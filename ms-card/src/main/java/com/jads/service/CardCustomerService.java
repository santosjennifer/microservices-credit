package com.jads.service;

import java.util.List;

import com.jads.dto.CardCustomerDto;

public interface CardCustomerService {

	List<CardCustomerDto> findByCpf(String cpf);
	
}
