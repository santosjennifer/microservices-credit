package com.jads.model;

import org.hibernate.validator.constraints.br.CPF;

import com.jads.dto.CustomerDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	@CPF(message = "O cpf deve ser válido")
	@Column(unique = true)
	@NotBlank(message = "O cpf deve ser informado")
	private String cpf;
	
	@NotBlank(message = "O nome deve ser informado")
	private String name;
	
	@Positive(message = "A idade deve ser um número positivo")
	private Integer age;
	
	public CustomerDto convertToDto() {
		return new CustomerDto(id, cpf, name, age);
	}
	
	public Customer() {}
	
	public Customer(String cpf, String name, Integer age) {
		this.cpf = cpf;
		this.name = name;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}
