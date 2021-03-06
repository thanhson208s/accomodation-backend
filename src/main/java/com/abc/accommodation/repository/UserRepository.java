package com.abc.accommodation.repository;

import com.abc.accommodation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhone(String phone);
    Optional<User> findByUsername(String username);
    Boolean existsByPhone(String phone);
    Boolean existsByUsername(String username);
}
