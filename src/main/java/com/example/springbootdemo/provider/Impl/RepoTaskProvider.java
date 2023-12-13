package com.example.springbootdemo.provider.Impl;

import com.example.springbootdemo.dao.TaskRepository;
import com.example.springbootdemo.model.Task;
import com.example.springbootdemo.model.TaskDTO;
import com.example.springbootdemo.provider.TaskProvider;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("repoProvider")
public class RepoTaskProvider implements TaskProvider {
    public static RepoTaskProvider create(TaskRepository repository) {
        var provider =  new RepoTaskProvider();
        provider.setRepository(repository);
        return provider;
    }
    private TaskRepository repository;

    public void setRepository(TaskRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<Task> provideTasks() {
        return repository.findAll();
    }

    @Override
    public Task getTaskById(UUID id) {
        return null;
    }

    // TODO: to implement it...
    @Override
    public Task create(TaskDTO dto) {
        throw new RuntimeException("Method not implemented!");
    }

    @Override
    public Task update(TaskDTO dto) {
        throw new RuntimeException("Method not implemented!");
    }

    @Override
    public Task delete(UUID id) {
        throw new RuntimeException("Method not implemented!");
    }
}
