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

    public EditPostRequest(Long id, String title, String location, Double price, String phone, String imageURL) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.price = price;
        this.phone = phone;
        this.imageURL = imageURL;
    }
}
