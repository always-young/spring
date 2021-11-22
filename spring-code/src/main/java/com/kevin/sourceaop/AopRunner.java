package com.kevin.sourceaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Code is far away from bug with the animal protecting
 *
 * @author kevin lau (双鹰)
 */
public class AopRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        final MessageService serviceProxy = applicationContext.getBean("messageService", MessageService.class);
        serviceProxy.sendMessage("hello aop");
    }
}
