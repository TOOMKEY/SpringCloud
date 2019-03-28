package tb;
import MyRibbon.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author TB
 * @date 2019/3/10 - 16:02
 **/
@SpringBootApplication
@EnableEurekaClient//Eureka服务注册
@RibbonClient(name = "PROVIDER",configuration = MySelfRule.class)//为自定义的Ribbon配置，使该微服务生效,主启动类多了此注解
public class Consumer_Ribbon {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_Ribbon.class,args);
    }
}
