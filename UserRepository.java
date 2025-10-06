package com.example.repository;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
}