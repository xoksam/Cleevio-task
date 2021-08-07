package com.cleevio.task.eshop.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
@EnableWebMvc
@EnableAsync
@EnableTransactionManagement
public class FullSpringConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter(ObjectMapperConfig.objectMapper));
        converters.add(new StringHttpMessageConverter());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        var javaUtilDateFormatter = new DateFormatter();
        javaUtilDateFormatter.setIso(DateTimeFormat.ISO.DATE_TIME);

        var javaUtilDate = new DateFormatterRegistrar();
        javaUtilDate.setFormatter(javaUtilDateFormatter);
        javaUtilDate.registerFormatters(registry);

        var jsr310 = new DateTimeFormatterRegistrar();
        jsr310.setDateTimeFormatter(DateTimeFormatter.ISO_DATE_TIME);
        jsr310.setDateFormatter(DateTimeFormatter.ISO_DATE);
        jsr310.setTimeFormatter(DateTimeFormatter.ISO_TIME);
        jsr310.registerFormatters(registry);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return ObjectMapperConfig.objectMapper;
    }
}
