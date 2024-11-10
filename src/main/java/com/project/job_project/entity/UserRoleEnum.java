package com.project.job_project.entity;


import lombok.Getter;

@Getter
public enum UserRoleEnum {
    ROLE_USER(Authority.USER);
    private final String authority;

    UserRoleEnum(String authority) {
        this.authority = authority;
    }

    private static class Authority {
        public static final String USER = "ROLE_USER";
    }

}