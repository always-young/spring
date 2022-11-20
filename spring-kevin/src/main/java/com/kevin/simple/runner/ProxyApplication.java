package com.kevin.simple.runner;

import com.kevin.simple.bean.First;
import com.kevin.simple.bean.Second;
import com.kevin.simple.config.IocConfig;
import com.kevin.simple.config.ProxyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author kevin lau (双鹰)
 */
public class ProxyApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProxyConfig.class);
        Second second = context.getBean(Second.class);
        First first = context.getBean(First.class);
        System.out.println(System.identityHashCode(second));
        System.out.println(System.identityHashCode(first.getSecond()));
    }
}
