package com.example.springbootdemo.model;

public interface Identifiable <K> {
    K getId();
    void setId(K id);
}
