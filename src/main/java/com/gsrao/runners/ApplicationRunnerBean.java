package com.gsrao.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class ApplicationRunnerBean implements ApplicationRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationRunnerBean.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("BOOT:My Sample ApplicationRunnerBean starting immediately after Spring Boot Application Starts !!");
    }
}
