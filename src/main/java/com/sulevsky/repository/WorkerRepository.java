package com.sulevsky.repository;

import com.sulevsky.model.Worker;

import java.util.List;

public interface WorkerRepository {
    void save(Worker worker);

    Worker find(String id);
    List<Worker> findAll();

    Worker delete(String id);

}
