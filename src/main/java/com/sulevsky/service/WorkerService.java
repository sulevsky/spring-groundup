package com.sulevsky.service;

import com.sulevsky.model.Worker;

import java.util.List;

public interface WorkerService {
    Worker createWorker(String firstName, String lastName);
    Worker findWorkerByFirstNameAndLastName(String firstName, String lastName);
    List<Worker> findAll();
}
