package com.abc.accommodation.controller;


import com.abc.accommodation.model.Post;
import com.abc.accommodation.repository.PostRepository;
import com.abc.accommodation.request.CreatePostRequest;
import com.abc.accommodation.request.DeletePostRequest;
import com.abc.accommodation.request.EditPostRequest;
import com.abc.accommodation.response.CreatePostResponse;
import com.abc.accommodation.response.DeletePostResponse;
import com.abc.accommodation.response.EditPostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts/")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public List<Post> getPosts() {
        System.out.println("OK\n");
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id){
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()){
            return ResponseEntity.ok(post.get());
        }
        else return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<CreatePostResponse> createPost(@RequestBody CreatePostRequest request) throws Exception {
        Post post = new Post(request);
        post = postRepository.save(post);
        CreatePostResponse response = new CreatePostResponse(post);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/edit")
    public ResponseEntity<EditPostResponse> editPost(@RequestBody EditPostRequest request) throws Exception {
        Optional<Post> post = postRepository.findById(request.getId());
        if (post.isPresent()){
            post.get().setTitle(request.getTitle());
            post.get().setLocation(request.getLocation());
            post.get().setPrice(request.getPrice());
            post.get().setPhone(request.getPhone());
            post.get().setImageURL(request.getImageURL());

            postRepository.save(post.get());
            EditPostResponse response = new EditPostResponse(post.get());
            return ResponseEntity.ok(response);
        }
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeletePostResponse> deletePost(@RequestBody DeletePostRequest request) throws Exception {
        Optional<Post> post = postRepository.findById(request.getId());
        if (post.isPresent()){
            postRepository.deleteById(post.get().getId());
            DeletePostResponse response = new DeletePostResponse(post.get());
            return ResponseEntity.ok(response);
        }
        else return ResponseEntity.notFound().build();
    }
}
