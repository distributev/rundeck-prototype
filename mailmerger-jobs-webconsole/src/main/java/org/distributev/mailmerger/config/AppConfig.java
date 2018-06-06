package org.distributev.mailmerger.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"org.distributev.mailmerger.controllers"})
@PropertySource({"classpath:application.properties"})
@EnableAutoConfiguration
@Import(WebMvcConfig.class)
public class AppConfig {

}
