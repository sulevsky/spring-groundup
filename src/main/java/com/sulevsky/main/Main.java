package com.sulevsky.main;

import com.sulevsky.model.Report;
import com.sulevsky.model.Task;
import com.sulevsky.model.Worker;
import com.sulevsky.repository.MemoryTaskRepository;
import com.sulevsky.repository.MemoryWorkerRepository;
import com.sulevsky.repository.TaskRepository;
import com.sulevsky.repository.WorkerRepository;
import com.sulevsky.service.AssignService;
import com.sulevsky.service.AssignServiceImpl;
import com.sulevsky.service.ReportGenerationService;
import com.sulevsky.service.ReportGenerationServiceImpl;
import com.sulevsky.service.TaskService;
import com.sulevsky.service.TaskServiceImpl;
import com.sulevsky.service.WorkerService;
import com.sulevsky.service.WorkerServiceImpl;
import com.sulevsky.view.ConsoleReportView;
import com.sulevsky.view.ReportView;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    private TaskRepository taskRepository = new MemoryTaskRepository();
    private TaskService taskService = new TaskServiceImpl(taskRepository);

    private WorkerRepository workerRepository = new MemoryWorkerRepository();
    private WorkerService workerService = new WorkerServiceImpl(workerRepository);
    private AssignService assignService = new AssignServiceImpl(taskService);

    private ReportGenerationService reportGenerationService = new ReportGenerationServiceImpl(taskService, workerService);

    private ReportView reportView = new ConsoleReportView();

    public static void main(String[] args) {
        Main main = new Main();
        main.createTestWorkers();
        main.createTestTasks();
        main.assignTasks();
        Report report = main.generateReport();
        main.showReport(report);

    }

    private Report generateReport() {
        return reportGenerationService.generateReport();
    }

    private void showReport(Report report) {
        reportView.showReport(report);
    }

    private void assignTasks() {
        List<Task> tasks = taskService.findAllTasks();
        List<Worker> workers = workerService.findAll();
        assignService.assignTask(workers.get(0), tasks.get(0));
        assignService.assignTask(workers.get(0), tasks.get(1));
        assignService.assignTask(workers.get(1), tasks.get(2));
        assignService.assignTask(workers.get(2), tasks.get(3));

    }

    private void createTestWorkers() {
        workerService.createWorker("Lena", "Lenova");
        workerService.createWorker("Ivan", "Ivanov");
        workerService.createWorker("Petr", "Petrov");
        workerService.createWorker("Alla", "Lazy");
    }

    private void createTestTasks() {
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
