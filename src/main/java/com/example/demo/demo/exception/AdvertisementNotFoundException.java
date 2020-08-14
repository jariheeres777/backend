package com.example.demo.demo.exception;

public class AdvertisementNotFoundException extends RuntimeException {

    public AdvertisementNotFoundException(Long id) {
        super("Could not find ad with id: " + id);
    }
    public AdvertisementNotFoundException(String errormassages){
        super(errormassages);
    }
}
