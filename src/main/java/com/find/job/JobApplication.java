package com.find.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
@EnableWebMvc
@EnableScheduling
@SpringBootApplication
public class JobApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
    }
}
