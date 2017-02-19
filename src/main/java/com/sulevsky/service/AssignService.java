package com.sulevsky.service;

import com.sulevsky.model.Task;
import com.sulevsky.model.Worker;

public interface AssignService {
    Task assignTask(Worker worker, Task task);
}
