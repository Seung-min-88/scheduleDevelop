package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.SignUpRequestDto;
import com.example.scheduledevelop.dto.UserRequestDto;
import com.example.scheduledevelop.dto.UserResponseDto;
import com.example.scheduledevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users/signup")
    public ResponseEntity<UserResponseDto> signup(@RequestBody SignUpRequestDto signUpRequestDto){
        UserResponseDto userResponseDto = userService.signUp(signUpRequestDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> findAllUser(){
        return new ResponseEntity<>(userService.findAllUser(), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponseDto> findUser(@PathVariable Long userId){
        return new ResponseEntity<>(userService.findUserById(userId), HttpStatus.OK);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<UserResponseDto> updateUserData(@PathVariable Long userId, @RequestBody UserRequestDto dto){
        return new ResponseEntity<>(userService.updateData(userId, dto), HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUserData(@PathVariable Long userId){
        userService.deleteUserData(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
