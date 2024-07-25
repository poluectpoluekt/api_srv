package com.edu.api_srv.exception.exception;

public class CurrencyNotFoundException extends RuntimeException{

    public CurrencyNotFoundException(String currencyName){
        super("No currency found in the list - " + currencyName);
    }
}
