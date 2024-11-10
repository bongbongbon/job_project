package com.project.job_project.dto;

import com.project.job_project.entity.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Authority {
    private String authorityName;

    // 단일 UserRoleEnum을 받아 authorityName을 설정하는 생성자
    public Authority(UserRoleEnum userRoleEnum) {
        this.authorityName = userRoleEnum.name();
    }

    // List<UserRoleEnum>을 받아 List<Authority>로 변환하는 정적 메서드
    public static List<Authority> fromUserRoles(List<UserRoleEnum> roles) {
        return roles.stream()
                .map(Authority::new) // UserRoleEnum을 Authority로 변환
                .collect(Collectors.toList());
    }
}

