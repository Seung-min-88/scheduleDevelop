package com.example.scheduledevelop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
public class User extends BaseEntity{

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    private String password;


    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public void update(Long id, String email, String name,  String password){
        this.id = id;
        if (email != null && !email.isEmpty()) {
            this.email = email;  // 이메일이 비어있지 않으면 업데이트
        }
        if (name != null && !name.isEmpty()) {
            this.name = name;  // 이름이 비어있지 않으면 업데이트
        }
        if (password != null && !password.isEmpty()) {
            this.password = password;  // 비밀번호가 비어있지 않으면 업데이트
        }
    }
}
