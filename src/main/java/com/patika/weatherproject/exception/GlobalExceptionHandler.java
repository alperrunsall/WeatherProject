package com.patika.weatherproject.exception;

import com.patika.weatherproject.exception.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WeatherException.class)
    public ResponseEntity<ExceptionResponse> handleWeatherException(WeatherException exception){

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(prepareExceptionResponse(exception, HttpStatus.NOT_FOUND));
    }
    private ExceptionResponse prepareExceptionResponse(Exception exception, HttpStatus httpStatus) {

        ExceptionResponse response = new ExceptionResponse();

        response.setHttpStatus(httpStatus);

        response.setMessage(exception.getMessage());

        return response;
    }

}
