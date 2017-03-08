package com.sulevsky.repository;

import com.sulevsky.model.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class MemoryTaskRepositoryTest {
    @Autowired
    private MemoryTaskRepository memoryTaskRepository;

    @Test
    public void shouldLogOnSave() throws Exception {
        memoryTaskRepository.save(new Task("id", "description", null, null, new BigDecimal(100)));
    }
}
