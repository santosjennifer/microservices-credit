package com.jads.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jads.dto.CustomerDto;
import com.jads.model.Customer;
import com.jads.repository.CustomerRepository;
import com.jads.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;

	@Override
	public Optional<CustomerDto> findByCpf(String cpf) {
		Optional<Customer> customer = repository.findByCpf(cpf);

		if(customer.isPresent()) {
			return Optional.of(customer.get().convertToDto());
		}
		
		return Optional.empty();
	}

	@Override
	public CustomerDto create(CustomerDto customerDto) {
		Customer customer = customerDto.convertToEntity();
		customer = repository.save(customer);

		return customer.convertToDto();
	}
	
}
