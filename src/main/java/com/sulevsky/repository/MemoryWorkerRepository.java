package com.sulevsky.repository;

import com.sulevsky.model.Worker;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MemoryWorkerRepository implements WorkerRepository {
    private Map<String, Worker> workerIdToWorker = new HashMap<>();

    @Override
    public void save(Worker worker) {
        workerIdToWorker.put(worker.getId(), worker);
    }

    @Override
    public Worker find(String id) {
        return workerIdToWorker.get(id);
    }

    @Override
    public List<Worker> findAll() {
        return workerIdToWorker.values().stream().collect(Collectors.toList());
    }

    @Override
    public Worker delete(String id) {
        return workerIdToWorker.remove(id);
    }
}
