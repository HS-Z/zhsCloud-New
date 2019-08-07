package com.zhs.monitor;

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
public class ZhsMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhsMonitorApplication.class, args);
    }

}
