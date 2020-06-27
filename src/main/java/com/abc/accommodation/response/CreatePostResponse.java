package com.abc.accommodation.response;

import com.abc.accommodation.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CreatePostResponse {
    private Long id;
    private String title;
    private String location;
    private Double price;
    private String phone;

    public CreatePostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.location = post.getLocation();
        this.price = post.getPrice();
        this.phone = post.getPhone();
    }
}