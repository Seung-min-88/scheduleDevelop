package com.example.scheduledevelop.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {

    private Long id;
    private String email;
    private String name;
    private String password;


    public UserResponseDto(Long id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    // 유저 정보 조회시
    public UserResponseDto(Long id, String email, String name){
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public UserResponseDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
