package com.example.scheduledevelop.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private final Long id;
    private final Long userId;
    private final String title;
    private final String todo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ScheduleResponseDto(Long id, Long userId, String title, String todo, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.todo = todo;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
    }

    public ScheduleResponseDto(Long id, Long userId, String title, String todo, LocalDateTime updatedAt){
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.todo = todo;
        this.updatedAt = updatedAt;
    }



}
