package com.example.scheduledevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@NoArgsConstructor
public class Schedule {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    private Long userId;
    private String title;
    private String todo;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    public Schedule(Long userId, String title, String todo) {
        this.userId = userId;
        this.title = title;
        this.todo = todo;
    }

    public void update(Long userId, String title, String todo, LocalDateTime updatedAt){
        this.userId = userId;
        this.title = title;
        this.todo = todo;
        this.updatedAt = updatedAt;
    }

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
