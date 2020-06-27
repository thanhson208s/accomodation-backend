package com.abc.accommodation.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DeletePostRequest {
    private Long id;

    public DeletePostRequest(Long id){
        this.id = id;
    }
}
