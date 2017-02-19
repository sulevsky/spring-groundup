package com.sulevsky.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Report {
    private List<ReportEntry> entries;

    public Report() {
        this.entries = new ArrayList<>();
    }

    public List<ReportEntry> getEntries() {
        return entries;
    }

    public void addEntry(ReportEntry reportEntry) {
        entries.add(reportEntry);
    }

    public void setEntries(List<ReportEntry> entries) {
        this.entries = entries;
    }

    public static class ReportEntry {
        private Worker worker;
        private Duration duration;
        private BigDecimal salary;

        public ReportEntry(Worker worker, Duration duration, BigDecimal salary) {
            this.worker = worker;
            this.duration = duration;
            this.salary = salary;
        }

        public Worker getWorker() {
            return worker;
        }

        public Duration getDuration() {
            return duration;
        }

        public BigDecimal getSalary() {
            return salary;
        }
    }
}
