package com.example.newswebsite.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicatedValueException extends Exception{
    public DuplicatedValueException(String message){
        super(message);
    }
}
