package com.sulevsky.service;

import com.sulevsky.model.Report;
import com.sulevsky.model.Task;
import com.sulevsky.model.Worker;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

public class ReportGenerationServiceImpl implements ReportGenerationService {

    private TaskService taskService;
    private WorkerService workerService;

    public ReportGenerationServiceImpl(TaskService taskService,
                                       WorkerService workerService) {
        this.taskService = taskService;
        this.workerService = workerService;
    }

    @Override
    public Report generateReport() {
        Report report = new Report();
        for (Worker worker : workerService.findAll()) {
            List<Task> workersTasks = taskService.findTasksAssignedToWorker(worker);
            totalDuration(workersTasks);
            Report.ReportEntry entry = new Report.ReportEntry(worker,
                                                              totalDuration(workersTasks),
                                                              totalSalary(workersTasks));
            report.addEntry(entry);
        }
        return report;
    }

    private Duration totalDuration(List<Task> workersTasks) {
        return workersTasks
                .stream()
                .map(task -> Duration.between(task.getFrom(), task.getTill()))
                .reduce(Duration::plus)
                .orElse(Duration.ZERO);
    }

    private BigDecimal totalSalary(List<Task> workersTasks) {
        return workersTasks
                .stream()
                .map(Task::getPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
