package com.jads.exception;

@SuppressWarnings("serial")
public class CardIssuanceException extends RuntimeException {

    public CardIssuanceException(String message) {
        super(message);
    }
    
}
