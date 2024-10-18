package com.sg.jdbctcomplexexample.dao;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
        value = CommandLineRunner.class))
@EnableAutoConfiguration
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)

public class TestApplicationConfiguration {

}
