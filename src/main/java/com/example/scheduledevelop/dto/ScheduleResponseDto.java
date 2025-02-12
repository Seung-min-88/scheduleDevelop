package com.example.scheduledevelop.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private final Long id;
    private UserResponseDto user;
    private final String title;
    private final String todo;

    public ScheduleResponseDto(Long id, UserResponseDto user, String title, String todo) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.todo = todo;
    }

    public ScheduleResponseDto(Long id, String title, String todo){
        this.id = id;
        this.title = title;
        this.todo = todo;
    }
}
