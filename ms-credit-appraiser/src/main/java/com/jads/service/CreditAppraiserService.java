package com.jads.service;

import com.jads.dto.CardIssuanceDataDto;
import com.jads.dto.CardRequestProtocolDto;
import com.jads.dto.ReturnCustomerReviewDto;
import com.jads.dto.StatusCustomerDto;

public interface CreditAppraiserService {
	
	StatusCustomerDto getStatusCustomer(String cpf);
	ReturnCustomerReviewDto doAssessment(String cpf, Long income);
	CardRequestProtocolDto requestCardIssuance(CardIssuanceDataDto data);
	
}
