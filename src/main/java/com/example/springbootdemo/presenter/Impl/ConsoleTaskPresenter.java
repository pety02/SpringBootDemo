package com.example.springbootdemo.presenter.Impl;

import com.example.springbootdemo.presenter.TaskPresenter;
import com.example.springbootdemo.provider.TaskProvider;
import com.example.springbootdemo.qualifiers.Default;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class ConsoleTaskPresenter implements TaskPresenter {
    private TaskProvider provider;

    @Inject
    public ConsoleTaskPresenter(@Default TaskProvider provider) {
        this.provider = provider;
    }

    @Override
    public void present() {
        provider.provideTasks().forEach(System.out::println);
    }
}
