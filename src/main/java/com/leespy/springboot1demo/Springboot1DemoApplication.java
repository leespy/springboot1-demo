package com.leespy.springboot1demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 新建Spring Boot项目后，生成的项目的根包目录下会有一个【artifactId】+"Application"命名规则的入口类，即：Springboot1DemoApplication
 * <p>
 * 运行：右键运行"Run Springboot1DemoApplication"
 * 访问：http://localhost:8080(默认请求地址，可以在application.properties文件中进行订制)
 */
@RestController
@SpringBootApplication // 它是Spring Boot项目的核心注解，主要目的是开启自动配置
// @ImportResource({"classpath:some-context.xml","classpath:another-context.xml"}) 引入xml配置
public class Springboot1DemoApplication {

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot";
    }

    /**
     * 这是一个标准的Java应用的main方法，主要作用是作为项目启动的入口
     */
    public static void main(String[] args) {
        SpringApplication.run(Springboot1DemoApplication.class, args);

        // 关闭Banner
        // SpringApplication app = new SpringApplication(Springboot1DemoApplication.class);
        // app.setBannerMode(Banner.Mode.OFF);
        //  app.run(args);

    }
}
