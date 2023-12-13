package com.example.springbootdemo.dao;

public interface IdGenerator<K> {
    K getNextId();
}
