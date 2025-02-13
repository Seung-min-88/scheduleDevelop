package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class LoginResponseDto {
    private Long userId;
    private String name;
    private String email;
    private String password;

    public LoginResponseDto(Long userId, String name, String email, String password){
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
