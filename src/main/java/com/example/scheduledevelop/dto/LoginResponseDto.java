package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class LoginResponseDto {
    private Long id;
    private String name;
    private String email;
    private String password;

    public LoginResponseDto(Long id, String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
