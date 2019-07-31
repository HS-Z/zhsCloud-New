package com.zhs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by zhs on 2019/7/31.
 */
@SpringBootApplication
@EnableEurekaServer
public class ZhsEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhsEurekaApplication.class, args);
    }

}
