package com.example.scheduledevelop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Schedule {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adId;

    private Long userId;
    private String title;
    private String todo;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
