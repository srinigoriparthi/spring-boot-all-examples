package com.gsrao.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CommandLineRunnerBean implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineRunnerBean.class);

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("BOOT:My Sample CommandLineRunnerBean starting immediately after Spring Boot Application Starts !!!!!");
    }
}
