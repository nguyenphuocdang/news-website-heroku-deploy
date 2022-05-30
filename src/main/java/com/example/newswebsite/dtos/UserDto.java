package com.example.newswebsite.dtos;

import com.example.newswebsite.dtos.account.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;
    private AccountDto account;
    private String email;
    private String phone;
    private String fullname;
    private String image;
    private String description;
    private String role;
}
