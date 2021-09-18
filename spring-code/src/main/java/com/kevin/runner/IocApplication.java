package com.kevin.runner;

import com.kevin.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Code is far away from bug with the animal protecting
 *
 * @author kevin lau (双鹰)
 */
public class IocApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(IocApplication.class);
        final User bean = context.getBean(User.class);
        System.out.println(bean);
    }
}
