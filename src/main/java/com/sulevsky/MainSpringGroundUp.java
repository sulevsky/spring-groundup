package com.sulevsky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(basePackageClasses = {MainSpringGroundUp.class, Jsr310JpaConverters.class})
@SpringBootApplication
public class MainSpringGroundUp {
    public static void main(String[] args) {
        SpringApplication.run(MainSpringGroundUp.class, args);
    }
}
