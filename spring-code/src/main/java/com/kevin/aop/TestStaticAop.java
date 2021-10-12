package com.kevin.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Code is far away from bug with the animal protecting
 *
 * @author kevin lau (双鹰)
 */
@Component
public class TestStaticAop extends StaticMethodMatcherPointcutAdvisor {

    public TestStaticAop(){
        setAdvice((MethodInterceptor) methodInvocation -> {
            System.out.println("方法执行");
            Object val =  methodInvocation.proceed();
            System.out.println("方法执行完毕");
            return val;
        });
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return method.isAnnotationPresent(Log.class);
    }
}
