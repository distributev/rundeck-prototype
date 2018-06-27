package org.distributev.mailmerger.config;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.distributev.mailmerger.service.JobService;
import org.distributev.mailmerger.service.impl.StubbedJobServiceImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import java.io.File;
import javax.servlet.ServletException;

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

    @Bean
    public TomcatServletWebServerFactory containerFactory() {
        return new TomcatServletWebServerFactory() {

            @Override
            protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
                // Ensure that the webapps directory exists
                new File(tomcat.getServer().getCatalinaBase(), "webapps").mkdirs();
                File warFile = new File("build/rundeck-2.11.4.war");

                try {
                    Context context = tomcat.addWebapp("/rundeck", warFile.getAbsolutePath());
                } catch (ServletException ex) {
                    throw new IllegalStateException("Failed to add webapp", ex);
                }
                return super.getTomcatWebServer(tomcat);
            }


        };

    }
}
