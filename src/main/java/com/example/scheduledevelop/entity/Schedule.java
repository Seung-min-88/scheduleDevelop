package com.example.scheduledevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@NoArgsConstructor
public class Schedule extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Setter
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;

    private Long userId;

    private String title;
    private String todo;


    public Schedule(Long userId, String title, String todo) {
        this.userId = userId;
        this.title = title;
        this.todo = todo;
    }

    public void update(Long userId, String title, String todo){
        this.userId = userId;
        this.title = title;
        this.todo = todo;
    }
}
