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

    public EditPostRequest(Long id, String title, String location, Double price, String phone) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.price = price;
        this.phone = phone;
    }
}
