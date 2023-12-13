package com.example.springbootdemo.dao;

import com.example.springbootdemo.model.Task;
import com.example.springbootdemo.model.TaskDTO;

import java.util.UUID;

public interface TaskRepository extends MyRepository<UUID, Task> {
    Task create(TaskDTO createDTO);

    Task update(TaskDTO updatedDTO);

    Task delete(TaskDTO deletedDTO);
}
