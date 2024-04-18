package com.jads.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jads.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, String>{
	
	List<Card> findByIncomeLessThanEqual(BigDecimal income);
	
}
