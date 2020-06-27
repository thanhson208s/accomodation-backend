package com.abc.accommodation.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
public class SignUpRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String phone;

    public SignUpRequest(@NotBlank String username, @NotBlank String password, @NotBlank String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
    }
}
