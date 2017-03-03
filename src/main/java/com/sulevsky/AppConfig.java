package com.sulevsky;

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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ReportView reportView() {
        return new ConsoleReportView();
    }

    @Bean
    public TaskRepository taskRepository() {
        return new MemoryTaskRepository();
    }

    @Bean
    public TaskService taskService() {
        System.out.println("----------Task service called");
        return new TaskServiceImpl(taskRepository());
    }

    @Bean
    public AssignService assignService() {
        return new AssignServiceImpl(taskService());
    }

    @Bean
    public WorkerRepository workerRepository() {
        return new MemoryWorkerRepository();
    }

    @Bean
    public WorkerService workerService(WorkerRepository workerRepository ) {
        return new WorkerServiceImpl(workerRepository);
    }

    @Bean
    public ReportGenerationService reportGenerationService(WorkerService workerService) {
        return new ReportGenerationServiceImpl(taskService(), workerService);
    }
}
