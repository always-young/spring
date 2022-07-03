package com.kevin.simple.config;

import com.kevin.simple.bean.MyBeanPostProcessor;
import com.kevin.simple.bean.MyInstantiationAwareBeanPostProcessor;
import com.kevin.simple.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kevin lau (双鹰)
 */
@Configuration
@ComponentScan("com.kevin.bean")
public class IocConfig {

    @Bean
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setUsername("kevin");
        return user;
    }

    @Bean
    public User user2() {
        User user = new User();
        user.setId(2L);
        user.setUsername("kevin2");
        return user;
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }

    @Bean
    public MyInstantiationAwareBeanPostProcessor myInstantiationAwareBeanPostProcessor(){
        return new MyInstantiationAwareBeanPostProcessor();
    }
}
