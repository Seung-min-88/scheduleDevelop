package com.example.scheduledevelop.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserRequestDto {

    private Long userId;
    private String name;
    private String email;
    private String password;

}
