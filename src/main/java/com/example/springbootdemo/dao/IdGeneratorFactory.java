package com.example.springbootdemo.dao;

public interface IdGeneratorFactory<K> {
    IdGenerator<K> createIdGenerator();
}
