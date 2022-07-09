package com.kevin.simple.runner;

import com.kevin.simple.bean.LifeCycle;
import com.kevin.simple.bean.UserService;
import com.kevin.simple.config.IocConfig;
import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author kevin lau (双鹰)
 */
public class IocApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);
//        val user = context.getBean("user2", User.class);
//        System.out.println(context.isTypeMatch("user2", ResolvableType.forClass(User.class)));
//        System.out.println(user);
//        System.out.println(Arrays.toString(context.getBeanNamesForType(User.class)));
//        val namedBeanHolder = context.getBeanFactory().resolveNamedBean(User.class);
//        System.out.println(namedBeanHolder);

        //测试循环依赖
        val lifeCycle = context.getBean(LifeCycle.class);
        val userService = context.getBean(UserService.class);
        lifeCycle.doSomeThing();
        userService.getCurrentUser();
    }
}