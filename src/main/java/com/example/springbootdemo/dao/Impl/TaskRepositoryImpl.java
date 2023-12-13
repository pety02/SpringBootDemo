package com.example.springbootdemo.dao.Impl;

import com.example.springbootdemo.dao.IdGenerator;
import com.example.springbootdemo.dao.TaskRepository;
import com.example.springbootdemo.dao.UserRepository;
import com.example.springbootdemo.model.Task;
import com.example.springbootdemo.model.TaskDTO;
import com.example.springbootdemo.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("tasksRepo")
public class TaskRepositoryImpl extends RepositoryImpl<UUID, Task> implements TaskRepository {
    public TaskRepositoryImpl(IdGenerator<UUID> idGen) {
        super(idGen);
    }

    @Override
    public Task create(TaskDTO createDTO) {
        Task t = new Task(createDTO.getTitle(), createDTO.getDescription(), createDTO.getCreatedBy());
        return create(t);
    }

    @Override
    public Task update(TaskDTO updatedDTO) {
        Task t = new Task(updatedDTO.getTitle(), updatedDTO.getDescription(), updatedDTO.getCreatedBy());
        t.setId(updatedDTO.getId());
        return update(t).get();
    }

    @Override
    public Task delete(TaskDTO deletedDTO) {
        return deleteById(deletedDTO.getId()).get();
    }
}
