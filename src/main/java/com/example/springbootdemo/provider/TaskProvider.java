package com.example.springbootdemo.provider;

import com.example.springbootdemo.model.Task;
import com.example.springbootdemo.model.TaskDTO;

import java.util.List;
import java.util.UUID;

public interface TaskProvider {
    List<Task> provideTasks();
    Task getTaskById(UUID id);
    Task create(TaskDTO dto);
    Task update(TaskDTO dto);
    Task delete(UUID id);
}
