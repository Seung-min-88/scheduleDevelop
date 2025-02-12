package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class LoginResponseDto {
    private String email;
    private String password;

    public LoginResponseDto(String email, String password){
        this.email = email;
        this.password = password;
    }
}
