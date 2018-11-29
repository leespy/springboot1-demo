
package com.leespy.springboot1demo.demo3;

import java.io.IOException;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.env.PropertySourcesLoader;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * 加载自定义配置文件
 * <p>
 * Date 2018/11/29 上午9:48
 * Author muse
 */
public class LoadAdditionalProperties implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    private ResourceLoader loader = new DefaultResourceLoader();

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        try {
            Resource resource = loader.getResource("classpath:config/author.properties");
            PropertySource<?> propertySource = new PropertySourcesLoader().load(resource);
            applicationEnvironmentPreparedEvent.getEnvironment().getPropertySources().addLast(propertySource);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}


