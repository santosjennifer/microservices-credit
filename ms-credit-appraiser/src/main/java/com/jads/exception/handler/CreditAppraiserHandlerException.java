package com.jads.exception.handler;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jads.exception.BodyResponse;
import com.jads.exception.CardIssuanceException;
import com.jads.exception.CustomerNotFoundException;

import feign.FeignException;
import feign.RetryableException;

@RestControllerAdvice
public class CreditAppraiserHandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BodyResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        String errorMessage = fieldError.getDefaultMessage();

        BodyResponse response = new BodyResponse(errorMessage);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CardIssuanceException.class)
    public ResponseEntity<BodyResponse> handleCardIssuanceException(CardIssuanceException ex) {
        BodyResponse response = new BodyResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<BodyResponse> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        BodyResponse response = new BodyResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler({ FeignException.ServiceUnavailable.class })
	public ResponseEntity<BodyResponse> handleFeignServiceUnavailable() {
		BodyResponse response = new BodyResponse("Serviço indisponível.");
		return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
    @ExceptionHandler({ RetryableException.class })
    public ResponseEntity<BodyResponse> handleRetryableException(RetryableException ex) {
    	String serviceName = extractServiceName(ex.request().url());
        String message = "Falha temporária na conexão com o serviço " + serviceName + ". Tente mais tarde.";
        BodyResponse response = new BodyResponse(message);
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }

    private String extractServiceName(String urlString) {
        try {
            URI uri = new URI(urlString);
            String[] pathSegments = uri.getPath().split("/");
            if (pathSegments.length > 1) {
                return pathSegments[1];
            }
        } catch (URISyntaxException ignored) {
        }
        return "Serviço Desconhecido";
    }
}
