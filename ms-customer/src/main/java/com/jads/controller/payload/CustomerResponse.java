package com.jads.controller.payload;

public class CustomerResponse {

	private String id;
	private String cpf;
	private String name;
	private Integer age;
	
	public CustomerResponse(String id, String cpf, String name, Integer age) {
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
