package com.example.scheduledevelop.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleRequestDto {

    private Long userId;
    private String title;
    private String todo;
    private LocalDateTime updatedAt;

}
