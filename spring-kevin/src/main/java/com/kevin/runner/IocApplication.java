package com.kevin.runner;

import com.kevin.bean.User;
import com.kevin.config.IocConfig;
import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.ResolvableType;

import java.util.Arrays;

/**
 * @author kevin lau (双鹰)
 */
public class IocApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);
        val user = context.getBean("user2", User.class);
        System.out.println(context.isTypeMatch("user2", ResolvableType.forClass(User.class)));
        System.out.println(user);
        System.out.println(Arrays.toString(context.getBeanNamesForType(User.class)));
    }
}
