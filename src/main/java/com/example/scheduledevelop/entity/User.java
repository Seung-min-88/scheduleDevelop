package com.example.scheduledevelop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "유효한 이메일 주소를 입력하세요.")
    @NotBlank(message = "이메일을 작성해주세요")
    private String email;

    @NotBlank(message = "이름을 작성해주세요.")
    private String name;

    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public User(Long id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }

//    public User (Long id, String name, String email){
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }

    public void update(Long id, String email, String name,  String password, LocalDateTime updatedAt){
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
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
