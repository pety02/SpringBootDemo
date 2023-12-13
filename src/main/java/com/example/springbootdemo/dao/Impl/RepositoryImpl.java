package com.example.springbootdemo.dao.Impl;

import com.example.springbootdemo.dao.IdGenerator;
import com.example.springbootdemo.dao.MyRepository;
import com.example.springbootdemo.model.Identifiable;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class RepositoryImpl<K, V extends Identifiable<K>> implements MyRepository<K, V> {

    private Map<K, V> entities = new ConcurrentHashMap<>();
    private IdGenerator<K> idGen;

    public RepositoryImpl(IdGenerator<K> idGen) {
        this.idGen = idGen;
    }
    @Override
    public List<V> findAll() {
        return new ArrayList<>(entities.values());
    }

    @Override
    public Optional<V> findById(K id) {
        return Optional.ofNullable(entities.get(id));
    }

    @Override
    public V create(V entity) {
        entity.setId(idGen.getNextId());
        entities.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<V> update(V entity) {
        entities.put(entity.getId(), entity);
        return Optional.ofNullable(entity);
    }

    @Override
    public Optional<V> deleteById(K id) {
        entities.remove(id);
        return Optional.ofNullable(entities.get(id));
    }
}