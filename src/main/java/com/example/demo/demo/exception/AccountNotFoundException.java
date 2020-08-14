package com.example.demo.demo.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(Long id) {
        super("Could not find account with id: " + id);
    }

    public AccountNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
