package com.example.scheduledevelop.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {

    private Long id;
    private String email;
    private String name;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserResponseDto(Long id, String email, String name, String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // 유저 정보 조회시
    public UserResponseDto(Long id, String email, String name, LocalDateTime createdAt){
        this.id = id;
        this.email = email;
        this.name = name;
        this.createdAt = createdAt;
    }
}
