package com.jads.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jads.model.CardCustomer;

@Repository
public interface CardCustomerRepository extends JpaRepository<CardCustomer, String> {

	List<CardCustomer> findByCpf(String cpf);

}
