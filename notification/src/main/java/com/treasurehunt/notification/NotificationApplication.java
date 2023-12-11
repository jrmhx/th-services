package com.treasurehunt.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(
        scanBasePackages = {
                "com.treasurehunt.notification",
                "com.treasurehunt.amqp",
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.treasurehunt.clients"
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }
}
