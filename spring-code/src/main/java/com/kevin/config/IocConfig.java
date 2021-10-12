package com.kevin.config;

import com.kevin.component.MyBeanFactoryPostProcessor;
import com.kevin.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Code is far away from bug with the animal protecting
 *
 * @author kevin lau (双鹰)
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.kevin")
public class IocConfig {

    @Bean
    public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor(){
    	MyBeanFactoryPostProcessor myBeanFactoryPostProcessor =  new MyBeanFactoryPostProcessor();
        return myBeanFactoryPostProcessor;
        
    }
}
