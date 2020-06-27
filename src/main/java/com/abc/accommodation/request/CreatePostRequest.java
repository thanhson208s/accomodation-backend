package com.abc.accommodation.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CreatePostRequest {
    private String title;
    private String location;
    private Double price;
    private String phone;

    public CreatePostRequest(String title, String location, Double price, String phone) {
        this.title = title;
        this.location = location;
        this.price = price;
        this.phone = phone;
    }
}