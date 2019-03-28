package tb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author TB
 * @date 2019/3/9 - 16:10
 */
@MapperScan(basePackages ="tb.mapper")
@SpringBootApplication
@EnableEurekaClient/*向Eureka注册服务*/
@EnableDiscoveryClient/*服务发现*/
public class Provider {
    public static void main(String[] args) {
        SpringApplication.run(Provider.class, args);
    }
}
