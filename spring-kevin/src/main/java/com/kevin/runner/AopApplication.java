package com.kevin.runner;

import com.kevin.bean.User;
import com.kevin.bean.UserService;
import com.kevin.config.AopConfig;
import com.kevin.config.IocConfig;
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
