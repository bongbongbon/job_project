package com.project.job_project.controller;

import com.project.job_project.dto.LoginRequestDto;
import com.project.job_project.dto.SignupRequestDto;
import com.project.job_project.dto.SignupResponseDto;
import com.project.job_project.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto requestDto) {
        return ResponseEntity.ok().body(authService.signup(requestDto));
    }

}
