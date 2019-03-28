package tb.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import tb.entity.Student;
import tb.services.studentService;
import tb.utils.Msg;

import java.util.List;

/**
 * @author TB
 * @date 2019/3/9 - 15:51
 **/
@RestController
@RequestMapping(value = "student")
public class studentController {
    @Autowired
    studentService studentService;
    @Autowired
    private DiscoveryClient client;//服务发现
    @GetMapping("{id}")
    public Msg get(@PathVariable String id)throws Exception{
        return Msg.success().add("msg",studentService.get(id));
    }
    @PostMapping
    public Msg add(@RequestBody Student student)throws Exception{
        studentService.add(student);
        return Msg.success().add("msg","添加成功");
    }
    @DeleteMapping("{id}")
    public Msg delete(@PathVariable String id)throws Exception{
        studentService.delete(id);
        return Msg.success().add("msg","删除成功");
    }
    @PutMapping
    public Msg update(@RequestBody Student student)throws Exception{
        studentService.update(student);
        return Msg.success().add("msg","修改成功");
    }
    @GetMapping
    public List<Student> getAll()throws Exception{
        /*return Msg.success().add("msg",studentService.getAll());*/
        return studentService.getAll();
    }

    /**
     * 用于服务发现
     * @return
     */
    @GetMapping("discovery")
    public Object discovery(){
        List<String> services = client.getServices();
        System.out.println("当前所有的服务:"+ services);
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-DEPT");
        for (ServiceInstance serviceInstance : instances) {
            System.out.println(""+serviceInstance.getServiceId()+"  "+serviceInstance.getHost()+"  "+serviceInstance.getPort()+"  "+serviceInstance.getUri());
        }
        return this.client;
    }
}
