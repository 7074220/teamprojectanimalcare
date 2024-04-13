package com.itwill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TeamprojectAnimalcareApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeamprojectAnimalcareApplication.class, args);
    }
}
