package com.sulevsky.service;

import com.sulevsky.model.Report;
import com.sulevsky.view.JsonReportViewImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class JsonReportViewImplTest {

    @Autowired
    JsonReportViewImpl reportView;

    @Test
    public void shouldInjectComponent() {
        Assert.assertNotNull(reportView);
    }

    @Test
    public void shouldReturnEmptyArrayOnEmptyReport() {
        String generatedView = reportView.generateView(new Report());
        String expected = "{\"entries\":[]}";
        Assert.assertEquals(expected, generatedView);
    }
}
