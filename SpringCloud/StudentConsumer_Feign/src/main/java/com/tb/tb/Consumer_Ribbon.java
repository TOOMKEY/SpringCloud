package com.tb.tb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author TB
 * @date 2019/3/10 - 16:02
 **/
@SpringBootApplication
@EnableEurekaClient//Eureka服务注册
@EnableFeignClients//开启Feign
public class Consumer_Ribbon {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_Ribbon.class,args);
    }
}
