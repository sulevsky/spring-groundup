package com.sulevsky.service;

import com.sulevsky.model.Task;
import com.sulevsky.model.Worker;
import org.springframework.stereotype.Service;

@Service
public class AssignServiceImpl implements AssignService {

    private TaskService taskService;

    public AssignServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public Task assignTask(Worker worker, Task task) {
        task.setAssigneeId(worker.getWorkerId());
        return taskService.saveTask(task);
    }
}
