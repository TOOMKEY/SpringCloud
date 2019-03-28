package com.tb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author TB
 * @date 2019/3/24 1:30 PM
 */
@SpringBootApplication
// EurekaServer 服务启动类 接受其他微服务注册进来
@EnableEurekaServer
public class Config_EurekaServer7001_App {

    public static void main(String[] args) {
        SpringApplication.run(Config_EurekaServer7001_App.class, args);
    }

}
