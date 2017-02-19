package com.sulevsky.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Task {
    private String id;
    private String description;
    private LocalDateTime from;
    private LocalDateTime till;
    private BigDecimal price;
    private Worker assignee;

    public Task(String id, String description, LocalDateTime from, LocalDateTime till, BigDecimal price) {
        this.id = id;
        this.description = description;
        this.from = from;
        this.till = till;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTill() {
        return till;
    }

    public void setTill(LocalDateTime till) {
        this.till = till;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Worker getAssignee() {
        return assignee;
    }

    public void setAssignee(Worker assignee) {
        this.assignee = assignee;
    }
}
