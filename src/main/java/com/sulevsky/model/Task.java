package com.sulevsky.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public class Task {
    @Id
    private String id;
    private String description;
    private LocalDateTime start;
    private LocalDateTime till;
    private BigDecimal price;
    private String assigneeId;

    public Task(String id, String description, LocalDateTime start, LocalDateTime till, BigDecimal price,
                String assigneeId) {
        this.id = id;
        this.description = description;
        this.start = start;
        this.till = till;
        this.price = price;
        this.assigneeId = assigneeId;
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

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
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

    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }
}
