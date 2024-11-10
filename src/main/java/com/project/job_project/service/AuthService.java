package com.project.job_project.service;

import com.project.job_project.dto.Authority;
import com.project.job_project.dto.SignupRequestDto;
import com.project.job_project.dto.SignupResponseDto;
import com.project.job_project.entity.User;
import com.project.job_project.entity.UserRoleEnum;
import com.project.job_project.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SignupResponseDto signup(SignupRequestDto requestDto) {

        String username = requestDto.getUsername();
        Optional<com.project.job_project.entity.User> checkUsername = userRepository.findByUsername(username);
        if (checkUsername.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }



        String password = passwordEncoder.encode(requestDto.getPassword());

        User user = User.builder()
                .username(requestDto.getUsername())
                .password(password)
                .role(UserRoleEnum.ROLE_USER)
                .build();

        List<UserRoleEnum> userRoles = Collections.singletonList(user.getRole());


        userRepository.save(user);
        return SignupResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .authorities(Authority.fromUserRoles(userRoles)) // 권한 리스트 변환 및 추가
                .build();
    }

}