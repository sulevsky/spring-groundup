package com.sulevsky.testdataloader;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.sulevsky.model.Task;
import com.sulevsky.model.Worker;
import com.sulevsky.service.AssignService;
import com.sulevsky.service.TaskService;
import com.sulevsky.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestDataLoader implements ApplicationRunner {

    private final WorkerService workerService;

    private final TaskService taskService;

    private final AssignService assignService;

    @Autowired
    public TestDataLoader(WorkerService workerService,
                          TaskService taskService,
                          AssignService assignService) {
        this.workerService = workerService;
        this.taskService = taskService;
        this.assignService = assignService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.createTestWorkers(workerService);
        this.createTestTasks(taskService);
        this.assignTasks(taskService, workerService, assignService);
    }

    private void assignTasks(TaskService taskService, WorkerService workerService, AssignService assignService) {
        List<Task> tasks = taskService.findAllTasks();
        List<Worker> workers = workerService.findAll();
        assignService.assignTask(workers.get(0), tasks.get(0));
        assignService.assignTask(workers.get(0), tasks.get(1));
        assignService.assignTask(workers.get(1), tasks.get(2));
        assignService.assignTask(workers.get(2), tasks.get(3));
    }

    private void createTestWorkers(WorkerService workerService) {
        workerService.createWorker("Lena", "Lenova");
        workerService.createWorker("Ivan", "Ivanov");
        workerService.createWorker("Petr", "Petrov");
        workerService.createWorker("Alla", "Lazy");
    }

    private void createTestTasks(TaskService taskService) {
        taskService.createTask("Clean room",
                               LocalDateTime.of(2017, 2, 22, 12, 0),
                               LocalDateTime.of(2017, 2, 22, 16, 0),
                               BigDecimal.valueOf(100.0));
        taskService.createTask("Cook dish",
                               LocalDateTime.of(2017, 2, 10, 8, 0),
                               LocalDateTime.of(2017, 2, 10, 15, 0),
                               BigDecimal.valueOf(300.0));

        taskService.createTask("Teach piano playing",
                               LocalDateTime.of(2017, 2, 22, 8, 0),
                               LocalDateTime.of(2017, 2, 22, 9, 0),
                               BigDecimal.valueOf(150.0));

        taskService.createTask("Fix bicycle",
                               LocalDateTime.of(2017, 2, 19, 8, 0),
                               LocalDateTime.of(2017, 2, 19, 18, 0),
                               BigDecimal.valueOf(801.0));
    }
}
