package com.devsian.user.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class UserLoginDTO {
    @NotBlank
    String userId;

    @NotBlank
    String password;

    public UserLoginDTO(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
