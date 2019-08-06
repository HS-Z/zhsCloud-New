package com.zhs.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by zhs on 2019/8/06.
 */
@SpringBootApplication
@EnableEurekaClient
public class ZhsGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhsGatewayApplication.class, args);
    }

}
