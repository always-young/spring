package com.kevin.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author kevin lau (双鹰)
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("lifeCycle")) {
            System.out.println("MyBeanPostProcessor before");
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("lifeCycle")) {
            System.out.println("MyBeanPostProcessor after");
        }
        return bean;
    }
}
