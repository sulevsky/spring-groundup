package com.sulevsky.repository;

import java.util.List;

import com.sulevsky.model.Worker;

public interface WorkerRepository {
    void save(Worker worker);

    Worker find(String id);
    List<Worker> findAll();

    Worker delete(String id);
}
