package com.sulevsky.service;

import java.util.List;

import com.sulevsky.model.Worker;

public interface WorkerService {
    Worker createWorker(String firstName, String lastName);
    Worker findWorkerByFirstNameAndLastName(String firstName, String lastName);
    List<Worker> findAll();
}
