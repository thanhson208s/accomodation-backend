package com.abc.accommodation.security;

import com.abc.accommodation.model.User;
import com.abc.accommodation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user =
                userRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(
                        "User not found  with phone: " + s));
        return new UserPrincipal(user.getId(), user.getUsername(), user.getPassword(), user.getPhone());
    }

    @Transactional
    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id: " + id)
        );

        return new UserPrincipal(user.getId(), user.getUsername(), user.getPassword(), user.getPhone());
    }
}
