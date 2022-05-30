package com.example.newswebsite.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictedOldValueException extends Exception{
    public ConflictedOldValueException(String message){
        super(message);
    }
}
