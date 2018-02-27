package com.sulevsky.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.sulevsky.model.Report;
import com.sulevsky.model.Task;
import com.sulevsky.model.Worker;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static java.util.Collections.singletonList;

public class ReportGenerationServiceImplTest {

    @Test
    public void generateReport() throws Exception {
        TaskService taskServiceMock = Mockito.mock(TaskService.class);
        Task dummyTask = new Task("1",
                                  "some description",
                                  LocalDateTime.parse("2017-02-03T10:15"),
                                  LocalDateTime.parse("2017-02-03T16:15"),
                                  BigDecimal.TEN);

        Mockito
                .when(taskServiceMock.findTasksAssignedToWorker(Mockito.any()))
                .thenReturn(singletonList(dummyTask));

        WorkerService workerServiceMock = Mockito.mock(WorkerService.class);
        Worker dummyWorker = new Worker("1", "Ivan", "Ivanov");
        Mockito
                .when(workerServiceMock.findAll())
                .thenReturn(singletonList(dummyWorker));

        ReportGenerationServiceImpl reportGenerationService = new ReportGenerationServiceImpl(taskServiceMock,
                                                                                              workerServiceMock);
        Report report = reportGenerationService.generateReport();
        Assert.assertEquals(1, report.getEntries().size());
        Assert.assertEquals(BigDecimal.TEN, report.getEntries().get(0).getSalary());
    }
}
