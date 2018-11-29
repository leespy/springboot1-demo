
package com.leespy.springboot1demo.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示application.properties属性注入
 *
 * Date 2018/11/29 上午9:06
 * Author muse
 */
@RestController
@SpringBootApplication
public class Demo1Application {

    @Value("${book.author}")
    private String bookAuthor;

    @Value("${book.name}")
    private String bookName;

    @RequestMapping("/")
    public String index() {
        return "book name is:" + bookName + " and book author is:" + bookAuthor;
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class);
    }
}
