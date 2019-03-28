package MyRibbon;
import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author TB
 * @date 2019/3/11 - 21:36
 **/
//Ribbon配置时,该类不能放在与主启动类同包下，或及其子包下。
@Configuration//配置类
public class MySelfRule {
    @Bean
    // 开启Ribbon负载均衡
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        // 提供了很多中便捷访问远程http的服务的方法
        // 是一种简单便捷的访问restful的服务模板类
        // 是spring 提供用于访问Rest服务的客户端模版工具集
        return new RestTemplate();
    }
    //负载均衡策略
    @Bean
    public IRule myIRule(){
        return  new RoundRule_TB();
    }
}
