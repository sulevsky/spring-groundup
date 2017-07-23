package com.sulevsky.controller;

import com.sulevsky.model.Report;
import com.sulevsky.service.ReportGenerationService;
import com.sulevsky.view.ReportView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ReportController {

    private ReportGenerationService reportGenerationService;

    private ReportView reportView;

    @Autowired
    public ReportController(ReportGenerationService reportGenerationService, ReportView reportView) {
        this.reportGenerationService = reportGenerationService;
        this.reportView = reportView;
    }

    @RequestMapping(method = GET, path = "/report")
    public String getReport() {
        Report report = reportGenerationService.generateReport();
        String printedReport = reportView.generateView(report);
        return printedReport;
    }
}
