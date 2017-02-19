package com.sulevsky.repository;

import com.sulevsky.model.Task;

import java.util.Collection;
import java.util.List;

public interface TaskRepository {
    Task save(Task task);
    Task find(String id);
    List<Task> findAll();
    Task delete(String id);
}
