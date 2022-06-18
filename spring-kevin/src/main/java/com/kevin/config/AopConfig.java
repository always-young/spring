package com.kevin.config;

import com.kevin.bean.User;
import com.kevin.log.LogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author kevin lau (双鹰)
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.kevin.bean")
public class AopConfig {

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
