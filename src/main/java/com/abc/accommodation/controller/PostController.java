package com.abc.accommodation.controller;


import com.abc.accommodation.model.Post;
import com.abc.accommodation.model.User;
import com.abc.accommodation.repository.PostRepository;
import com.abc.accommodation.repository.UserRepository;
import com.abc.accommodation.request.CreatePostRequest;
import com.abc.accommodation.request.DeletePostRequest;
import com.abc.accommodation.request.EditPostRequest;
import com.abc.accommodation.response.CreatePostResponse;
import com.abc.accommodation.response.DeletePostResponse;
import com.abc.accommodation.response.EditPostResponse;
import com.abc.accommodation.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/posts/")
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/")
    public List<Post> getPosts(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        List<Post> posts = new ArrayList<>();
        for (Post post : postRepository.findAll()){
            if (post.getUser().getId() == userPrincipal.getId()){
                posts.add(post);
            }
        }
        return posts;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id, @AuthenticationPrincipal UserPrincipal userPrincipal){
        Optional<Post> post = postRepository.findById(id);

        if (post.isPresent()){
            if(post.get().getUser().getId() == userPrincipal.getId()){
                return ResponseEntity.ok(post.get());
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<CreatePostResponse> createPost(@RequestBody CreatePostRequest request, @AuthenticationPrincipal UserPrincipal userPrincipal) throws Exception {
        Optional<User> user = userRepository.findByUsername(userPrincipal.getUsername());
        if (user.isPresent()) {
            Post post = new Post(request);
            post.setUser(user.get());
            post = postRepository.save(post);
            CreatePostResponse response = new CreatePostResponse(post);
            return ResponseEntity.ok(response);
        }
        else return ResponseEntity.notFound().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<EditPostResponse> editPost(@RequestBody EditPostRequest request, @AuthenticationPrincipal UserPrincipal userPrincipal) throws Exception {
        Optional<Post> post = postRepository.findById(request.getId());
        if (post.isPresent()){
            post.get().setTitle(request.getTitle());
            post.get().setLocation(request.getLocation());
            post.get().setPrice(request.getPrice());
            post.get().setPhone(request.getPhone());
            post.get().setImageURL(request.getImageURL());
            post.get().setDescription(request.getDescription());
            postRepository.save(post.get());
            EditPostResponse response = new EditPostResponse(post.get());
            return ResponseEntity.ok(response);
        }
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeletePostResponse> deletePost(@RequestBody DeletePostRequest request, @AuthenticationPrincipal UserPrincipal userPrincipal) throws Exception {
        Optional<Post> post = postRepository.findById(request.getId());
        if (post.isPresent()){
            postRepository.deleteById(post.get().getId());
            DeletePostResponse response = new DeletePostResponse(post.get());
            return ResponseEntity.ok(response);
        }
        else return ResponseEntity.notFound().build();
    }
}
