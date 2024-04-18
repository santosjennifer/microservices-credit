package com.jads.controller.payload;

import com.jads.dto.CustomerDto;

public class CustomerRequest {

	private String cpf;
	private String name;
	private Integer age;
	
	public CustomerDto convertToDto() {
		return new CustomerDto(cpf, name, age);
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
