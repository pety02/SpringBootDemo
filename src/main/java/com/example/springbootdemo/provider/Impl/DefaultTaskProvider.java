package com.example.springbootdemo.provider.Impl;

import com.example.springbootdemo.dao.IdGenerator;
import com.example.springbootdemo.dao.Impl.UUIDIdGeneratorImpl;
import com.example.springbootdemo.model.Task;
import com.example.springbootdemo.model.TaskDTO;
import com.example.springbootdemo.model.User;
import com.example.springbootdemo.provider.TaskProvider;
import com.example.springbootdemo.qualifiers.Default;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

@Service
@Qualifier("defaultProvider")
@Default
public class DefaultTaskProvider implements TaskProvider {
    @Override
    public List<Task> provideTasks() {
        User currentUser = new User(UUID.randomUUID(), "petya.licheva2002@abv.bg", "Petya Licheva", "myPass0000");
        return List.of(
                new Task(UUID.randomUUID(), "math homework", "solving math problems", currentUser),
                new Task(UUID.randomUUID(), "history presentation", "presentation on topic World War II", currentUser),
                new Task(UUID.randomUUID(), "english lesson", "listening compreheension", currentUser)
        );
    }

    @Override
    public Task getTaskById(UUID id) {
        Optional<Task> t = provideTasks().stream().findFirst().filter(new Predicate<Task>() {
            @Override
            public boolean test(Task task) {
                return task.getId() == id;
            }
        });

        return t.orElseThrow();
    }

    @Override
    public Task create(TaskDTO dto) {
        Task t = new Task(dto.getTitle(), dto.getDescription(), dto.getCreatedBy());
        IdGenerator<UUID> generator = new UUIDIdGeneratorImpl();
        UUID nextId = generator.getNextId();
        t.setId(nextId);
        provideTasks().add(t);
        return t;
    }

    @Override
    public Task update(TaskDTO dto) {
        Optional<Task> before = provideTasks().stream().findFirst().filter(new Predicate<Task>() {
            @Override
            public boolean test(Task task) {
                return task.getId() == dto.getId();
            }
        });
        Task now = new Task(dto.getTitle(), dto.getDescription(), dto.getCreatedBy());
        provideTasks().remove(before.orElseThrow());
        provideTasks().add(now);

        return now;
    }

    @Override
    public Task delete(UUID id) {
        Optional<Task> before = provideTasks().stream().findFirst().filter(new Predicate<Task>() {
            @Override
            public boolean test(Task task) {
                return task.getId() == id;
            }
        });

        provideTasks().remove(before.orElseThrow());

        return before.orElseThrow();
    }
}
