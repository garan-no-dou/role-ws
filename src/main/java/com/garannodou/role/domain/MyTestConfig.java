package com.garannodou.role.domain;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyTestConfig {

    @Bean(name = "myTestBean")
    @ConditionalOnProperty(prefix = "app.test", name = "property", havingValue = "true")
    public TestBean testBean() {
        return new TestBean() {
        };
    }

}
