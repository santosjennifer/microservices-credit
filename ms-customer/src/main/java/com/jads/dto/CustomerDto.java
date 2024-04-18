package com.jads.dto;

import com.jads.controller.payload.CustomerResponse;
import com.jads.model.Customer;

public class CustomerDto {

	private String id;
	private String cpf;
	private String name;
	private Integer age;
	
	public CustomerResponse convertToResponse() {
		return new CustomerResponse(id, cpf, name, age);
	}
	
	public Customer convertToEntity() {
		return new Customer(cpf, name, age);
	}
	
	public CustomerDto(String cpf, String name, Integer age) {
		this.cpf = cpf;
		this.name = name;
		this.age = age;
	}
	
	public CustomerDto(String id, String cpf, String name, Integer age) {
		this.id = id;
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
