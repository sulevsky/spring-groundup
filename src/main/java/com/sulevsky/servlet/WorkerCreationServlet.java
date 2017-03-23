package com.sulevsky.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulevsky.service.WorkerService;
import org.springframework.context.ApplicationContext;

public class WorkerCreationServlet extends HttpServlet {

    private WorkerService workerService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        ApplicationContext applicationContext = (ApplicationContext) config.getServletContext().getAttribute
                ("applicationContext");
        this.workerService = applicationContext.getBean(WorkerService.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");

        workerService.createWorker(firstName, lastName);
    }
}
