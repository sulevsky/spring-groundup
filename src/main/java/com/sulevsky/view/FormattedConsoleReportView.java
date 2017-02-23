package com.sulevsky.view;

import com.sulevsky.model.Report;

public class FormattedConsoleReportView implements ReportView {

    @Override
    public void showReport(Report report) {
        System.out.println("------------------------------------");
        for (Report.ReportEntry reportEntry : report.getEntries()) {
            System.out.print(String.format("%s\t%s\t%s\t%s\n",
                                             reportEntry.getWorker().getLastName(),
                                             reportEntry.getWorker().getFirstName(),
                                             reportEntry.getDuration().toHours(),
                                             reportEntry.getSalary().doubleValue()));
        }
        System.out.println("-----------------------------------");
    }
}
