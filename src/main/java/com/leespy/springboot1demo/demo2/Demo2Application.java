
package com.leespy.springboot1demo.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date 2018/11/29 上午9:26
 * Author muse
 */
@RestController
@SpringBootApplication
public class Demo2Application {

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    public String index() {
        return "author name is:" + authorSettings.getName() + " and author age is:" + authorSettings.getAge();
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }
}
