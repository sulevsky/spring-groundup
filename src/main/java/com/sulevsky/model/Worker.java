package com.sulevsky.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Worker {
    @Id
    private String worker_id;
    private String firstName;
    private String lastName;

    public Worker(String worker_id, String firstName, String lastName) {
        this.worker_id = worker_id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Worker() {
    }

    public String getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(String worker_id) {
        this.worker_id = worker_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
