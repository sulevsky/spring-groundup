package com.sulevsky.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.sulevsky.model.Task;
import com.sulevsky.model.Worker;

public interface TaskService {
    Task createTask(String description, LocalDateTime from, LocalDateTime to, BigDecimal price);
    Task saveTask(Task task);
    List<Task> findAllTasks();
    List<Task> findTasksAssignedToWorker(Worker worker);
}
