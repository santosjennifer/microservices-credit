package com.jads.exception.handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jads.exception.BodyResponse;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class CustomerHandlerException {

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
	
    @ExceptionHandler(UnsatisfiedServletRequestParameterException.class)
    public ResponseEntity<BodyResponse> handleUnsatisfiedServletRequestParameterException(UnsatisfiedServletRequestParameterException ex) {
        String errorMessage = "Parâmetro 'cpf' não fornecido.";

        BodyResponse response = new BodyResponse(errorMessage);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<BodyResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String errorMessage = "CPF já cadastrado.";

        BodyResponse response = new BodyResponse(errorMessage);
        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
}
