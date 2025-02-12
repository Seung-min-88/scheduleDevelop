package com.example.scheduledevelop.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private final Long id;
    private final Long userId;
    private final String title;
    private final String todo;

    public ScheduleResponseDto(Long id, Long userId, String title, String todo) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.todo = todo;
    }
}
