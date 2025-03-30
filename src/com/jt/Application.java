package com.jt;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author jokerjt
 * @version 1.0
 * @date 2025/3/30 19:08
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages = {"com.jt"})
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
