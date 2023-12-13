package com.example.springbootdemo.dao;

import com.example.springbootdemo.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends MyRepository<UUID, User> {
    Optional<User> findByUsername(String username);
}
