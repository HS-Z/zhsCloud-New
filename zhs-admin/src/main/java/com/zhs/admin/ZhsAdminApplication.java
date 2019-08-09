package com.zhs.admin;

import com.zhs.common.ZhsCommonApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by zhs on 2019/8/05.
 */
@SpringBootApplication
@EnableEurekaClient
public class ZhsAdminApplication extends ZhsCommonApplication{

    public static void main(String[] args) {
        SpringApplication.run(ZhsAdminApplication.class, args);
    }

}
