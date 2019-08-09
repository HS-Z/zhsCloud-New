package com.zhs.admin;

import com.zhs.common.ZhsCommonApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by zhs on 2019/8/05.
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.zhs.admin.mapper")
public class ZhsAdminApplication extends ZhsCommonApplication{

    public static void main(String[] args) {
        SpringApplication.run(ZhsAdminApplication.class, args);
    }

}
