package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.LoginResponseDto;
import com.example.scheduledevelop.dto.SignUpRequestDto;
import com.example.scheduledevelop.dto.UserResponseDto;
import com.example.scheduledevelop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping("/users/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody SignUpRequestDto loginDto, HttpServletRequest request){
        LoginResponseDto loginResponseDto= userService.login(loginDto.getEmail(),loginDto.getPassword());
        return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
    }

}
