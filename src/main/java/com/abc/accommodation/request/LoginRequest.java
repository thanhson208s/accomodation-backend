package com.abc.accommodation.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
public class LoginRequest {
    @NotBlank
    private String phone;
    @NotBlank
    private String password;

    public LoginRequest(@NotBlank String phone, @NotBlank String password) {
        this.phone = phone;
        this.password = password;
    }
}
