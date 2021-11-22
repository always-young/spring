package com.kevin.sourceaop;

import lombok.val;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Code is far away from bug with the animal protecting
 *
 * @author kevin lau (双鹰)
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public LogInterceptor logInterceptor() {
        return new LogInterceptor();
    }
    
    @Bean
    public NameMatchMethodPointcutAdvisor nameMatchMethodPointcutAdvisor(){
    	NameMatchMethodPointcutAdvisor nameMatchMethodPointcutAdvisor =  new NameMatchMethodPointcutAdvisor();
        nameMatchMethodPointcutAdvisor.setMappedName("sendMessage");
        nameMatchMethodPointcutAdvisor.setAdvice(logInterceptor());
        return nameMatchMethodPointcutAdvisor;
    }
    
    @Bean
    public MessageService messageService() {
        return new ConsoleMessageServiceImpl();
    }

    // 单个
//    @Bean
//    public ProxyFactoryBean serviceProxy(MessageService messageService) {
//        val proxyFactoryBean = new ProxyFactoryBean();
//        proxyFactoryBean.setInterceptorNames("nameMatchMethodPointcutAdvisor");
//        proxyFactoryBean.setTarget(messageService);
//        return proxyFactoryBean;
//    }

//    @Bean
//    public BeanNameAutoProxyCreator beanNameAutoProxyCreator(){
//    	BeanNameAutoProxyCreator beanNameAutoProxyCreator =  new BeanNameAutoProxyCreator();
//        beanNameAutoProxyCreator.setBeanNames("messageService");
//        beanNameAutoProxyCreator.setInterceptorNames("nameMatchMethodPointcutAdvisor");
//        return beanNameAutoProxyCreator;
//
//    }

//     @Bean
//     public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
//     	DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator =  new DefaultAdvisorAutoProxyCreator();
//         return defaultAdvisorAutoProxyCreator;
//     }
}
