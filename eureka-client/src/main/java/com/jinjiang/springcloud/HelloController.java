package com.jinjiang.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Laoer on 16/8/8.
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @Autowired
    UserService userService;

    //@HystrixCommand(fallbackMethod = "sayError")
    @RequestMapping(value = "/say/{name}")
    public String sayHello(@PathVariable(value = "name") String name) {
        return helloService.execHello(name);
    }

    public String sayError(String name) {
        return "Error : " + name;
    }


    @RequestMapping(value = "/uid/{id}")
    public UserDto findUserById(@PathVariable(value = "id") Long id) {
        return userService.findUserById(id);
    }

}
