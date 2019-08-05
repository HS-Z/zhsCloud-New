package com.zhs.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by zhs on 2019/8/04.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
public class ZhsAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhsAdminApplication.class, args);
    }

}
