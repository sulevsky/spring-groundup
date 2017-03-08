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


    public MemoryTaskRepository(Map<String, Integer> initialMessagesToRepeat) {
        for (Map.Entry<String, Integer> messageToRepeatNum : initialMessagesToRepeat.entrySet()) {
            for (int i = 0; i < messageToRepeatNum.getValue(); i++) {
                System.out.println("MemoryTaskRepository: " + messageToRepeatNum.getKey());
            }
        }
        this.taskIdToTask = new HashMap<>();
    }

    @Override
    public Task save(Task task) {
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
