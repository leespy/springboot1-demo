
package com.leespy.springboot1demo.demo2;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 类型安全的Bean
 *
 * Date 2018/11/29 上午9:17
 * Author muse
 */
@Component
@ConfigurationProperties(prefix = "author") // 加载properties文件内的配置，并通过prefix指定配置的前缀；
public class AuthorSettings {

    private String name;

    private Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
