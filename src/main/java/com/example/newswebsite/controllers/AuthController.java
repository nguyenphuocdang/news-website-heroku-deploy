package com.example.newswebsite.controllers;

import com.example.newswebsite.dtos.UserDto;
import com.example.newswebsite.entities.User;
import com.example.newswebsite.exceptions.*;
import com.example.newswebsite.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")


public class AuthController {
    @Autowired
    private AuthService authService;

    /***
     * @author: Unfame
     * @return: Account's information has just been registered
     * @throws DuplicatedValueException : Return Exception if Email was duplicated
     * @throws DuplicatedValueException : Return Exception if Username was duplicated
     */
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody UserDto userDto) throws DuplicatedValueException{
        return new ResponseEntity<>(authService.register(userDto), HttpStatus.OK);
    }

    /***
     * @author: Unfame
     * @return: Account's information has just been logged in
     * @throws NonexistentValueException : Return Exception if no User was founded
     * @throws IncorrectValueException : Return Exception if Password was wrong
     */
    @PostMapping("/login")
    public ResponseEntity<User> login(@Valid @RequestBody UserDto userDto) throws NonexistentValueException, IncorrectValueException {
        return new ResponseEntity<>(authService.login(userDto), HttpStatus.OK);
    }
}
