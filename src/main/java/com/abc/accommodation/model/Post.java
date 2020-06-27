package com.abc.accommodation.model;

import com.abc.accommodation.request.CreatePostRequest;
import com.abc.accommodation.request.EditPostRequest;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String location;
    private Double price;
    private String phone;
    //private String images;


    public Post(String title, String location, Double price, String phone) {
        this.title = title;
        this.location = location;
        this.price = price;
        this.phone = phone;
    }

    public Post(CreatePostRequest request){
        this.title = request.getTitle();
        this.location = request.getLocation();
        this.price = request.getPrice();
        this.phone = request.getPhone();
    }

    public Post(EditPostRequest request){
        this.id = request.getId();
        this.title = request.getTitle();
        this.location = request.getLocation();
        this.price = request.getPrice();
        this.phone = request.getPhone();
    }
}
