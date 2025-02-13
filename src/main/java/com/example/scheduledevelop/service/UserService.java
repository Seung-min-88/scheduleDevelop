package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.*;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto signUp(SignUpRequestDto dto){
        User user = new User(dto.getEmail(), dto.getName(), dto.getPassword());
        User saveUser = userRepository.save(user);

        return new UserResponseDto(saveUser.getId(), saveUser.getEmail(), saveUser.getName());
    }

    @Transactional
    public LoginResponseDto login(LoginRequestDto dto){
        User user = userRepository.findByEmail(dto.getEmail()).orElseThrow(()-> new IllegalArgumentException("해당 이메일의 유저가 존재하지 않습니다"));

        if(!user.getPassword().equals(dto.getPassword())){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return new LoginResponseDto(user.getId(),user.getName(), user.getEmail(), user.getPassword());
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findAllUser(){
        List<User> users = userRepository.findAll();

        List<UserResponseDto> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(new UserResponseDto(user.getId(), user.getEmail(), user.getName()));
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public UserResponseDto findUserById(Long userId){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 존재하지 않습니다")
        );
        return new UserResponseDto(user.getId(), user.getEmail(), user.getName());
    }

    @Transactional
    public UserResponseDto updateData(Long userId, UserRequestDto dto){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 존재하지 않습니다")
        );
        user.update(dto.getUserId(), dto.getEmail(), dto.getName(), dto.getPassword());

        return new UserResponseDto(user.getId(), user.getEmail(), user.getName());
    }

    @Transactional
    public void deleteUserData(Long userId){
        if(!userRepository.existsById(userId)){
            throw  new IllegalArgumentException("해당 유저가 존재하지 않습니다");
        }
        userRepository.deleteById(userId);
    }

}
