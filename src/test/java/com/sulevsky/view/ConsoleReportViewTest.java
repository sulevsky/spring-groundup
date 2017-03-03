package com.sulevsky.view;

import com.sulevsky.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ConsoleReportViewTest {

    @Autowired
    private ReportView reportView;
    @Test
    public void shouldInjectReportViewBean() throws Exception {
        Assert.assertNotNull(reportView);
    }
}
