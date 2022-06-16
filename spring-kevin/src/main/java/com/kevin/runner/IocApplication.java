package com.kevin.runner;

import com.kevin.bean.User;
import com.kevin.config.IocConfig;
import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author kevin lau (双鹰)
 */
public class IocApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);
        val user= context.getBean(User.class);
        System.out.println(user);
    }
}
