package com.leespy.springboot1demo.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leespy.springboot1demo.demo2.Demo2Application;

/**
 * 引入指定的properties文件   resources/config/author.properties
 * <p>
 * Date 2018/11/29 上午9:26
 * Author muse
 */
@RestController
@SpringBootApplication
public class Demo3Application {

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String index() {
        return "other author name is:" + env.getProperty("other.author.name") + " and other author age is:" + env.getProperty("other.author.age");
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Demo3Application.class).listeners(new LoadAdditionalProperties()).run(args);
    }
}
