package com.sulevsky.controller;

import com.sulevsky.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkerCreationController {

    private WorkerService workerService;

    @Autowired
    public WorkerCreationController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping("/workers")
    protected void createWorker(@RequestParam("first_name") String firstName,
                                @RequestParam("last_name") String lastName) {
        workerService.createWorker(firstName, lastName);
    }
}
