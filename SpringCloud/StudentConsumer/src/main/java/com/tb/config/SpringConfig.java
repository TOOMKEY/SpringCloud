package com.tb.config;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author TB
 * @date 2019/3/9 - 17:20
 **/
@Configuration
public class SpringConfig {
    @Bean
    // 开启Ribbon负载均衡
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        // 提供了很多中便捷访问远程http的服务的方法
        // 是一种简单便捷的访问restful的服务模板类
        // 是spring 提供用于访问Rest服务的客户端模版工具集
        return new RestTemplate();
    }

    /**Ribbon的负载均衡策略及原理
     * 使用负载均衡带来的好处很明显:
     * 当集群里的1台或者多台服务器down的时候，剩余的没有down的服务器可以保证服务的继续使用
     * 使用了更多的机器保证了机器的良性使用，不会由于某一高峰时刻导致系统cpu急剧上升
     * 常用方法：
     * 1随机 (Random)
     * 2轮询 (RoundRobin)
     * 3AvailabilityFilteringRule过滤掉一直连接失败并被标记为 circuit tripped 的 Server，过滤掉那些高并发连接的 Server（active connections 超过配置的网值）
     * 4ZoneAvoidanceRule综合判断 Server 所在区域的性能和 Server 的可用性轮询选择 Server，并且判定一个 AWS Zone 的运行性能是否可用，剔除不可用的 Zone 中的所有 Server
     * 5ResponseTimeWeightedRule根据 Server 的响应时间分配权重。响应时间越长，权重越低，被选择到的概率就越低；响应时间越短，权重越高，被选择到的概率就越高。
     * 6RetryRule在一个配置时问段内当选择 Server 不成功，则一直尝试选择一个可用的 Server
     * 7BestAvailableRule逐个考察 Server，如果 Server 断路器打开，则忽略，再选择其中并发连接最低的 Server
     * @return
     */
    @Bean
    public IRule myRule(){
        // 用随机算法代替默认的轮询算法
//        return new RandomRule();
        // 重试算法
        return new RetryRule();
    }
}