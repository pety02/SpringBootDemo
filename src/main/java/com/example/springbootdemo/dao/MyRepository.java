package com.example.springbootdemo.dao;

import com.example.springbootdemo.model.Identifiable;

import java.util.List;
import java.util.Optional;

public interface MyRepository<K, V extends Identifiable<K>> {
    List<V> findAll();
    Optional<V> findById(K id);
    V create(V entity);
    Optional<V> update(V entity);
    Optional<V> deleteById(K id);
}
