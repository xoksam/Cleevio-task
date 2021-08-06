package com.cleevio.task.eshop.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class BaseSpringConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return ObjectMapperConfig.objectMapper;
    }
}
