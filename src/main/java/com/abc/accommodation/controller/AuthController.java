package com.abc.accommodation.controller;

import com.abc.accommodation.model.User;
import com.abc.accommodation.repository.UserRepository;
import com.abc.accommodation.request.LoginRequest;
import com.abc.accommodation.request.SignUpRequest;
import com.abc.accommodation.response.LoginResponse;
import com.abc.accommodation.response.SignUpResponse;
import com.abc.accommodation.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@CrossOrigin
@RestController
@RequestMapping("/api/auth/")
public class AuthController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signUp(@Valid @RequestBody SignUpRequest request){
        if (userRepository.existsByPhone(request.getPhone()))
            return new ResponseEntity(new SignUpResponse(false, "Phone is already used!"), HttpStatus.BAD_REQUEST);
        if (userRepository.existsByUsername(request.getUsername()))
            return new ResponseEntity(new SignUpResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
        User user = new User(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(user.getUsername()).toUri();

        return ResponseEntity.created(location).body(new SignUpResponse(true, "User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        userRepository.findByUsername(request.getUsername()).ifPresent(user -> {
            user.setJwt(jwt);
            userRepository.save(user);
        });
        return ResponseEntity.ok(new LoginResponse(jwt));
    }
}
