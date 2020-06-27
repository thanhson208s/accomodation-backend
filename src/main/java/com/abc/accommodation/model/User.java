package com.abc.accommodation.model;

import com.abc.accommodation.request.SignUpRequest;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "_user")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String jwt;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String avatar;

    @Column(unique = true, nullable = false)
    private String phone;

    @OneToMany(mappedBy = "user")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Post> posts = new ArrayList<>();

    public User(String username, String password, String phone){
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public User(SignUpRequest request){
        this.username = request.getUsername();
        this.password = request.getPassword();
        this.phone = request.getPhone();
    }
}
