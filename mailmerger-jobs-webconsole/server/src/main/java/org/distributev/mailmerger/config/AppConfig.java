package org.distributev.mailmerger.config;

import org.distributev.mailmerger.service.JobService;
import org.distributev.mailmerger.service.impl.StubbedJobServiceImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"org.distributev.mailmerger.controller"})
@PropertySource({"classpath:application.properties"})
@EnableAutoConfiguration
@Import({WebConfig.class})
public class AppConfig {

    @Bean
    public JobService jobService() {
        return new StubbedJobServiceImpl();
    }
}
