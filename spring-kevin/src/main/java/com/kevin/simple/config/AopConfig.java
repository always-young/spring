package com.kevin.simple.config;

import com.kevin.simple.log.LogAspect;
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
