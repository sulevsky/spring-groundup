package com.sulevsky.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulevsky.model.Report;
import com.sulevsky.service.ReportGenerationService;
import com.sulevsky.view.ReportView;
import org.springframework.context.ApplicationContext;

public class ReportServlet extends HttpServlet {

    private ReportGenerationService reportGenerationService;

    @Inject
    public void setReportView(ReportView reportView) {
        this.reportView = reportView;
    }

    private ReportView reportView;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        ApplicationContext applicationContext = (ApplicationContext) config.getServletContext().getAttribute
                ("applicationContext");
        this.reportGenerationService = applicationContext.getBean(ReportGenerationService.class);
        this.reportView = applicationContext.getBean(ReportView.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Report report = reportGenerationService.generateReport();
        String printedReport = reportView.generateView(report);
        ServletOutputStream outputStream = resp.getOutputStream();

        outputStream.print(printedReport);
        outputStream.close();
    }
}
