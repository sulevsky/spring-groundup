package com.sulevsky.repository;

import java.util.List;

import com.sulevsky.model.Task;

public interface TaskRepository {
    Task save(Task task);
    Task find(String id);
    List<Task> findAll();
    Task delete(String id);
}
