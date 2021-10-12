package com.kevin.runner;

import com.kevin.config.IocConfig;
import com.kevin.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Code is far away from bug with the animal protecting
 *
 * @author kevin lau (双鹰)
 */
public class IocApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);
        final UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getUser());
    }
}
