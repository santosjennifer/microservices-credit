package com.jads.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity(name = "card")
public class Card {
	
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @NotBlank(message = "O nome do cartão de ser informado")
    private String name;
    
    @Enumerated(EnumType.STRING)
    @NotNull(message = "A bandeira do cartão deve ser informada")
    private CardBrand brand;
    
    @NotNull(message = "A renda do cartão deve ser informada")
    private BigDecimal income;
    
    @NotNull(message = "O limite básico do cartão deve ser informado")
    private BigDecimal basicLimit;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CardBrand getBrand() {
		return brand;
	}
	public void setBrand(CardBrand brand) {
		this.brand = brand;
	}
	public BigDecimal getIncome() {
		return income;
	}
	public void setIncome(BigDecimal income) {
		this.income = income;
	}
	public BigDecimal getBasicLimit() {
		return basicLimit;
	}
	public void setBasicLimit(BigDecimal basicLimit) {
		this.basicLimit = basicLimit;
	}

}
