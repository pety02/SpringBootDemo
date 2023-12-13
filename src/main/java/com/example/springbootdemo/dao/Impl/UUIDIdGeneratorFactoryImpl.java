package com.example.springbootdemo.dao.Impl;

import com.example.springbootdemo.dao.IdGenerator;
import com.example.springbootdemo.dao.IdGeneratorFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDIdGeneratorFactoryImpl implements IdGeneratorFactory<UUID> {
    @Override
    public IdGenerator<UUID> createIdGenerator() {
        return new UUIDIdGeneratorImpl();
    }
}
