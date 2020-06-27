package com.abc.accommodation.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class EditPostRequest {
    private Long id;
    private String title;
    private String location;
    private Double price;
    private String phone;
    private String imageURL;
    private String description;


    public EditPostRequest(Long id, String title, String location, Double price, String phone, String imageURL, String description) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.price = price;
        this.phone = phone;
        this.imageURL = imageURL;
        this.description = description;
    }
}
