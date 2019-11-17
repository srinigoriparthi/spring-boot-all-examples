package com.gsrao;

import com.gsrao.dao.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * SpringBootAllExamplesApplication
 */
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringBootAllExamplesApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootAllExamplesApplication.class);

    public static void main(String[] args) {
        LOGGER.info("BOOT:My Spring Boot Application starting !!");
        SpringApplication.run(SpringBootAllExamplesApplication.class, args);
    }
}
