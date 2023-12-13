package com.example.springbootdemo;

import com.example.springbootdemo.dao.TaskRepository;
import com.example.springbootdemo.dao.UserRepository;
import com.example.springbootdemo.model.TaskDTO;
import com.example.springbootdemo.model.User;
import com.example.springbootdemo.presenter.TaskPresenter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    static final List<User> repoUsers = List.of(
            new User("petya.licheva@abv.bg", "petya", "petya123"),
            new User("john.doe@abv.bg", "john", "john123"),
            new User("jane.doe@abv.bg", "jane", "jane123")
    );
    static final List<TaskDTO> repoTasks = java.util.List.of(
            new TaskDTO("Article 1", "Article 1 content ...", new User("petya.licheva@abv.bg", "petya", "petya123")),
            new TaskDTO("Article 2", "Article 2 content ...", new User("john.doe@abv.bg", "john", "john123")),
            new TaskDTO("Article 3", "Article 3 content ...", new User("jane.doe@abv.bg", "jane", "jane123"))
    );
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.example.springbootdemo");
        UserRepository userRepo = ctx.getBean(UserRepository.class);
        repoUsers.forEach(userRepo::create);
        TaskRepository repo = ctx.getBean(TaskRepository.class);
        repoTasks.forEach(repo::create);

        TaskPresenter presenter = ctx.getBean(TaskPresenter.class);
        presenter.present();
    }
}