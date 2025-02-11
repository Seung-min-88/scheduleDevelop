package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.UserRequestDto;
import com.example.scheduledevelop.dto.UserResponseDto;
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


    public UserResponseDto saveUser(UserRequestDto dto){
        User user = new User(dto.getId(), dto.getEmail(), dto.getName(),  dto.getPassword());
        User saveUser = userRepository.save(user);

        return new UserResponseDto(saveUser.getId(), saveUser.getEmail(), saveUser.getName(), saveUser.getPassword(), saveUser.getCreatedAt(), saveUser.getUpdatedAt());
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findAllUser(){
        List<User> users = userRepository.findAll();

        List<UserResponseDto> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(new UserResponseDto(user.getId(), user.getEmail(), user.getName(),user.getCreatedAt()));
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public UserResponseDto findUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 존재하지 않습니다")
        );
        return new UserResponseDto(user.getId(), user.getEmail(), user.getName(), user.getCreatedAt());
    }

    @Transactional
    public UserResponseDto updateData(Long id, UserRequestDto dto){
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 존재하지 않습니다")
        );
        user.update(dto.getId(), dto.getEmail(), dto.getName(), dto.getPassword(), dto.getUpdatedAt());

        return new UserResponseDto(user.getId(), user.getEmail(), user.getName(), user.getPassword(), user.getCreatedAt(), user.getUpdatedAt());
    }

    @Transactional
    public void deleteUserData(Long id){
        if(!userRepository.existsById(id)){
            throw  new IllegalArgumentException("해당 유저가 존재하지 않습니다");
        }
        userRepository.deleteById(id);
    }

}
