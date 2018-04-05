package com.sulevsky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackageClasses = {MainSpringGroundUp.class})
@SpringBootApplication
public class MainSpringGroundUp {
    public static void main(String[] args) {
        SpringApplication.run(MainSpringGroundUp.class, args);
    }
}
