package com.tb.controller;
import com.tb.entity.Student;
import com.tb.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author linjingze
 * @date 2019/1/20 11:16 AM
 */
@RestController
@RequestMapping("consumer")
public class StudentControllerConsumer {
    /*使用IP进行访问
    private final static String RESTPRE = "http://localhost:8001";*/
    /*使用微服务名称进行访问,注意字母大写*/
    private final static String RESTPRE = "http://PROVIDER";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("list")
    /*注意返回类型一定要与提供者返回类型一致*/
    public List<Student> list(){
        return restTemplate.getForObject(RESTPRE + "/student", List.class);
    }
}
