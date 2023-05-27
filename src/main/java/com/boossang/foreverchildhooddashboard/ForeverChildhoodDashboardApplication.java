package com.boossang.foreverchildhooddashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableFeignClients
@EnableConfigurationProperties
public class ForeverChildhoodDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForeverChildhoodDashboardApplication.class, args);
    }

}
