package com.tb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author TB
 * @date 2019/3/27 - 16:04
 **/
@SpringBootApplication
@EnableZuulProxy//开启网关
public class StudentGateway {
    public static void main(String[] args) {
        SpringApplication.run(StudentGateway.class, args);
    }
}
