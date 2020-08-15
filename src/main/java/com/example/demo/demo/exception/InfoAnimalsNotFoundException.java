package com.example.demo.demo.exception;

public class InfoAnimalsNotFoundException extends RuntimeException {

    public InfoAnimalsNotFoundException(Long id) { super("Could not find animal with id: " + id); }

    public InfoAnimalsNotFoundException(String errormassages) { super(errormassages); }
}
