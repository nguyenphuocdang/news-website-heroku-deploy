package com.example.newswebsite.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NonexistentValueException extends Exception{
    public NonexistentValueException(String message){
        super(message);
    }
}
