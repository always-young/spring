package com.kevin.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * Code is far away from bug with the animal protecting
 *
 * @author kevin lau (双鹰)
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if (beanFactory instanceof DefaultListableBeanFactory) {
            DefaultListableBeanFactory deDefaultListableBeanFactory = (DefaultListableBeanFactory)beanFactory;
            deDefaultListableBeanFactory.setAutowireCandidateResolver(new MyAnnotationAutowireCandidateResolver(deDefaultListableBeanFactory.getAutowireCandidateResolver()));
        }
    }
}
