package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.LoginRequestDto;
import com.example.scheduledevelop.dto.LoginResponseDto;
import com.example.scheduledevelop.dto.SignUpRequestDto;
import com.example.scheduledevelop.dto.UserResponseDto;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.service.UserService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto dto, HttpServletRequest request){
        LoginResponseDto loginResponseDto = userService.login(dto);

        HttpSession session = request.getSession(false); // 없을시 null 반환(실패한 적이 있다면 세션이 있을수도)
        if (session == null) {
            session = request.getSession(true);  // 없을경우 있게 만들어줌
        }


        if (loginResponseDto != null) {
            log.info("로그인 성공 유저(userId, name, email) = {}, {}, {}",
                    loginResponseDto.getUserId(),
                    loginResponseDto.getName(),
                    loginResponseDto.getEmail());
            session.setAttribute("userId", loginResponseDto.getUserId());
            session.setMaxInactiveInterval(1800); //30분
        }
        return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
    }

    @PutMapping("/logout")
    private ResponseEntity<Void> logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null){
            session.invalidate();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
