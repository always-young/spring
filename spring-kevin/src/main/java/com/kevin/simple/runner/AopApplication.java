package com.kevin.simple.runner;

import com.kevin.simple.bean.UserService;
import com.kevin.simple.config.AopConfig;
import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author kevin lau (双鹰)
 */
public class AopApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        val userService = context.getBean(UserService.class);
        System.out.println(userService.getCurrentUser());
    }
}
