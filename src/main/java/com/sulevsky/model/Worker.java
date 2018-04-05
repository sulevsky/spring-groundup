package com.sulevsky.model;

import org.springframework.data.annotation.Id;

public class Worker {
    @Id
    private String workerId;
    private String firstName;
    private String lastName;

    public Worker(String workerId, String firstName, String lastName) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Worker() {
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
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
