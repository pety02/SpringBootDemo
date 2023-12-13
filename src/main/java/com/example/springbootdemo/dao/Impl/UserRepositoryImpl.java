package com.example.springbootdemo.dao.Impl;

import com.example.springbootdemo.dao.IdGenerator;
import com.example.springbootdemo.dao.UserRepository;
import com.example.springbootdemo.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("usersRepo")
public class UserRepositoryImpl extends RepositoryImpl<UUID, User> implements UserRepository {
    public UserRepositoryImpl(IdGenerator<UUID> idGen) {
        super(idGen);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        for(var u : findAll()) {
            if(u.getUsername().equals(username)) {
                return Optional.of(u);
            }
        }

        return Optional.empty();
    }
}
