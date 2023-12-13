package com.example.springbootdemo.web;

import com.example.springbootdemo.model.Task;
import com.example.springbootdemo.model.TaskDTO;
import com.example.springbootdemo.provider.Impl.DefaultTaskProvider;
import com.example.springbootdemo.provider.TaskProvider;
import com.example.springbootdemo.qualifiers.Default;
import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.inject.Inject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Inject
    @Qualifier("defaultProvider")
    @Default
    private final TaskProvider taskProvider = new DefaultTaskProvider();

    @GetMapping
    List<Task> findAll() {
        return taskProvider.provideTasks();
    }

    @GetMapping("{id}")
    Task findTaskById(UUID id) {
        return taskProvider.getTaskById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Task> create(@RequestBody TaskDTO taskDTO) {
        var created = taskProvider.create(taskDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().pathSegment("{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/update")
    Task update (TaskDTO taskDTO) {
        return taskProvider.update(taskDTO);
    }

    @DeleteMapping("/delete")
    Task delete(UUID id) {
        return taskProvider.delete(id);
    }
}
