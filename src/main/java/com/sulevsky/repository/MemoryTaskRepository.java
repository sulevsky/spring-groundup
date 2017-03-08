package com.sulevsky.repository;

import com.sulevsky.model.Task;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MemoryTaskRepository implements TaskRepository {
    private Map<String, Task> taskIdToTask;
    private List<String> messagesToLogOnSave;

    public MemoryTaskRepository() {
        this.taskIdToTask = new HashMap<>();
    }

    public void setMessagesToLogOnSave(List<String> messagesToLogOnSave) {
        this.messagesToLogOnSave = messagesToLogOnSave;
    }

    @Override
    public Task save(Task task) {
        for (String message : messagesToLogOnSave) {
            System.out.println(message);
        }
        taskIdToTask.put(task.getId(), task);
        return task;
    }

    @Override
    public Task find(String id) {
        return taskIdToTask.get(id);
    }

    @Override
    public List<Task> findAll() {
        return taskIdToTask.values().stream().collect(Collectors.toList());
    }

    @Override
    public Task delete(String id) {
        return taskIdToTask.remove(id);
    }
}
