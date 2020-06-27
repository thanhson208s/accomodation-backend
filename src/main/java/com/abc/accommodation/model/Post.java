package com.abc.accommodation.model;

import com.abc.accommodation.request.CreatePostRequest;
import com.abc.accommodation.request.EditPostRequest;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
    private String imageURL;

    @ManyToOne(optional = false)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "username")
    @JsonIdentityReference(alwaysAsId = true)
    private User user;

    public Post(String title, String location, Double price, String phone, String imageURL, User user) {
        this.title = title;
        this.location = location;
        this.price = price;
        this.phone = phone;
        this.imageURL = imageURL;
        this.user = user;
    }

    public Post(CreatePostRequest request){
        this.title = request.getTitle();
        this.location = request.getLocation();
        this.price = request.getPrice();
        this.phone = request.getPhone();
        this.imageURL = request.getImageURL();
    }

    public Post(EditPostRequest request){
        this.id = request.getId();
        this.title = request.getTitle();
        this.location = request.getLocation();
        this.price = request.getPrice();
        this.phone = request.getPhone();
        this.imageURL = request.getImageURL();
    }
}
