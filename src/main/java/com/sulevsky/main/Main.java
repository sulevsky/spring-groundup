package com.sulevsky.main;

import com.sulevsky.model.Report;
import com.sulevsky.model.Task;
import com.sulevsky.model.Worker;
import com.sulevsky.service.AssignService;
import com.sulevsky.service.ReportGenerationService;
import com.sulevsky.service.TaskService;
import com.sulevsky.service.WorkerService;
import com.sulevsky.view.ReportView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("application-context.xml");

        WorkerService workerService = applicationContext.getBean(WorkerService.class);
        TaskService taskService = applicationContext.getBean(TaskService.class);
        AssignService assignService = applicationContext.getBean(AssignService.class);
        ReportGenerationService reportGenerationService = applicationContext.getBean(ReportGenerationService.class);
        ReportView reportView = applicationContext.getBean(ReportView.class);

        Main main = new Main();
        main.createTestWorkers(workerService);
        main.createTestTasks(taskService);
        main.assignTasks(taskService, workerService, assignService);
        Report report = main.generateReport(reportGenerationService);
        main.showReport(report, reportView);

    }

    private Report generateReport(ReportGenerationService reportGenerationService) {
        return reportGenerationService.generateReport();
    }

    private void showReport(Report report, ReportView reportView) {
        reportView.showReport(report);
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
