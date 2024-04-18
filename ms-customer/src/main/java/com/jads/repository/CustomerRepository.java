package com.jads.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jads.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

	Optional<Customer> findByCpf(String cpf);
	
}
