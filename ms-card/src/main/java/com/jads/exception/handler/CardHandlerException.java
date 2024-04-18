package com.jads.exception.handler;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.jads.exception.BodyResponse;
import com.jads.model.CardBrand;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class CardHandlerException {
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<BodyResponse> handlerValidationExceptions(ConstraintViolationException ex) {
		String errorMessage = ex.getConstraintViolations()
                .stream()
                .findFirst()
                .map(violation -> violation.getMessage())
                .orElse("Erro de validação");

		BodyResponse response = new BodyResponse(errorMessage);
		return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<BodyResponse> handlerInvalidFormatException(InvalidFormatException ex) {
		 String errorMessage = String.format("Valores aceitos para a bandeira do cartão: %s", 
		            Arrays.stream(CardBrand.values()).map(Enum::toString).collect(Collectors.joining(", ")));

		BodyResponse response = new BodyResponse(errorMessage);
		return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
    @ExceptionHandler(UnsatisfiedServletRequestParameterException.class)
    public ResponseEntity<BodyResponse> handleUnsatisfiedServletRequestParameterException(UnsatisfiedServletRequestParameterException ex) {
        String errorMessage = "Parâmetro 'cpf' ou 'income' não fornecido.";

        BodyResponse response = new BodyResponse(errorMessage);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
	
}
