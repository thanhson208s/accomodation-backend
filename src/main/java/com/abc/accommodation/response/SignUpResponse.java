package com.abc.accommodation.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SignUpResponse {
    private Boolean success;
    private String message;

    public SignUpResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
