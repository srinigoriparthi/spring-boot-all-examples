package com.gsrao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBootAllExamplesApplication
 */
@SpringBootApplication
public class SpringBootAllExamplesApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootAllExamplesApplication.class);

    public static void main(String[] args) {
        LOGGER.info("BOOT:My Spring Boot Application starting !!");
        SpringApplication.run(SpringBootAllExamplesApplication.class, args);
    }
}
