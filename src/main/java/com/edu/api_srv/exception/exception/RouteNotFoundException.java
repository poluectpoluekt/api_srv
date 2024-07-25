package com.edu.api_srv.exception.exception;

public class RouteNotFoundException extends RuntimeException{

    public RouteNotFoundException(){
        super("No available route found.");
    }
}
