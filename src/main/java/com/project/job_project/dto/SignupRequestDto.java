package com.project.job_project.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class SignupRequestDto {
    private String username;
    private String password;
    private String nickname;
}