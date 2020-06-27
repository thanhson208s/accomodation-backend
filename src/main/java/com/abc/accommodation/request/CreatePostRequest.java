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
    private String imageURL;
    private String description;

    public CreatePostRequest(String title, String location, Double price, String phone, String imageURL, String description) {
        this.title = title;
        this.location = location;
        this.price = price;
        this.phone = phone;
        this.imageURL = imageURL;
        this.description = description;
    }
}
