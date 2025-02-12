package com.example.scheduledevelop.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {

    private Long id;
    private String email;
    private String name;

    public UserResponseDto(Long id){
        this.id =id;
    }

//    public UserResponseDto(Long id, String email, String name) {
//        this.id = id;
//        this.email = email;
//        this.name = name;
//
//    }

    // 유저 정보 조회시
    public UserResponseDto(Long id, String email, String name){
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public UserResponseDto(String email) {
        this.email = email;
    }
}
