package com.tb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author TB
 * @date 2019/3/27 - 22:42
 **/
@SpringBootApplication
@EnableConfigServer
public class Config {
    public static void main(String[] args) {
        SpringApplication.run(Config.class,args);
    }
}
