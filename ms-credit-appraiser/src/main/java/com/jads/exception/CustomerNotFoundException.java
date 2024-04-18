package com.jads.exception;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException() {
        super("Dados do cliente não encontrados para o CPF informado.");
    }
    
}
