
package com.leespy.springboot1demo.demo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leespy.springbootstarterhello.HelloService;

/**
 * Date 2018/12/7 9:53 AM
 * Author muse
 */
@RestController
@SpringBootApplication
public class Ch65Application {

    @Autowired
    public HelloService helloService;

    @RequestMapping("/")
    public String index() {
        return helloService.getMsg();
    }

    public static void main(String[] args) {
        SpringApplication.run(Ch65Application.class, args);
    }
}
