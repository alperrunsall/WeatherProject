package com.patika.weatherproject.exception;

public class WeatherException extends RuntimeException{

    private String message;

    public WeatherException(String message){
        super(message);
        this.message = message;
    }
}
