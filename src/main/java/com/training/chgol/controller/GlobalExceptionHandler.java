package com.training.chgol.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.training.chgol.dto.ExceptionDto;

import static com.training.chgol.dto.ExceptionDto.Type.APPLICATION_EXCEPTION;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity onException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity(new ExceptionDto(APPLICATION_EXCEPTION), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
