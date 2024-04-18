package com.jads.controller.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AssessmentDataRequest {

	@NotBlank(message = "O cpf deve ser informado")
    private String cpf;
	
	@NotNull(message = "A renda deve ser informada")
    private Long income;
    
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Long getIncome() {
		return income;
	}
	public void setIncome(Long income) {
		this.income = income;
	}
    
}
