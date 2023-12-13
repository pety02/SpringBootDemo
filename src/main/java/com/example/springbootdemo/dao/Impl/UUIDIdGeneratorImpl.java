package com.example.springbootdemo.dao.Impl;

import com.example.springbootdemo.dao.IdGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDIdGeneratorImpl implements IdGenerator<UUID> {
    @Override
    public UUID getNextId() {
        return UUID.randomUUID();
    }
}
