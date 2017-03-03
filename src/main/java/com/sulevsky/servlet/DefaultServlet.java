package com.sulevsky.servlet;

import com.sulevsky.AppConfig;
import com.sulevsky.model.Report;
import com.sulevsky.model.Task;
import com.sulevsky.model.Worker;
import com.sulevsky.service.AssignService;
import com.sulevsky.service.ReportGenerationService;
import com.sulevsky.service.TaskService;
import com.sulevsky.service.WorkerService;
import com.sulevsky.view.ReportView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class DefaultServlet extends HttpServlet {

    private ReportGenerationService reportGenerationService;

    @Autowired
    private ReportView reportView;

    @Override
    public void init() throws ServletException {
        super.init();

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);

        WorkerService workerService = applicationContext.getBean(WorkerService.class);
        TaskService taskService = applicationContext.getBean(TaskService.class);
        AssignService assignService = applicationContext.getBean(AssignService.class);

        this.reportGenerationService = applicationContext.getBean(ReportGenerationService.class);
        this.reportView = applicationContext.getBean(ReportView.class);
        this.createTestWorkers(workerService);
        this.createTestTasks(taskService);
        this.assignTasks(taskService, workerService, assignService);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Report report = reportGenerationService.generateReport();
        String printedReport = reportView.generateView(report);
        ServletOutputStream outputStream = resp.getOutputStream();

        outputStream.print(printedReport);
        outputStream.close();
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
