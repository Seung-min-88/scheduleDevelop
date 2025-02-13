package com.example.scheduledevelop.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter {

    private static final String[] WHITE_LIST = {"/", "/users/signup", "/login", "/logout"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        log.info("로그인 필터 로직 실행");

        //화이트 리스트에 포함된 경우 true > !ture > false
        if (!isWhiteList(requestURI)) {

            HttpSession session = httpRequest.getSession(false);
            if (session == null || session.getAttribute("userId") == null){
                throw new RuntimeException("로그인 해주세요");
            }

            log.info("로그인에 성공하였습니다");

        }

        // 1번 경우 :  화이트 리스트에 등록된 유알엘이면 바로 체인두필터가 호출
        // 2번 경우 : 화이트 리스트가 아닌 경우 위의 필터 로직을 통과후 체인두필터로 다음 필터나 서블릿을 호출
        // 다음 필터가 없으면 서블릿이나 컨드롤러, 다음 필터가 있으면 다음 필터를 호출
        filterChain.doFilter(servletRequest, servletResponse);

    }

    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }

}
