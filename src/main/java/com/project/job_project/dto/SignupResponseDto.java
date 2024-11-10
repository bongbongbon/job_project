package com.project.job_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class SignupResponseDto {
    private final Long id;
    private final String username;
    private List<Authority> authorities;
}

