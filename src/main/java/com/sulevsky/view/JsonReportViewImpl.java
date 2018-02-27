package com.sulevsky.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sulevsky.model.Report;
import org.springframework.stereotype.Component;

@Component
public class JsonReportViewImpl implements ReportView {
    @Override
    public void showReport(Report report) {
        System.out.println(generateView(report));
    }

    @Override
    public String generateView(Report report) {
        ObjectMapper objectMapper = new ObjectMapper();
        String valueAsString = null;
        try {
            valueAsString = objectMapper.writeValueAsString(report);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            valueAsString = "{error:\"Can't serialize\"}";
        }
        return valueAsString;
    }
}
