package com.kevin.bean;

import lombok.val;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author kevin lau (双鹰)
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {


    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(beanName.equals("lifeCycle")) {
            System.out.println("MyInstantiationAwareBeanPostProcessor  before");
            Constructor<?> constructor = findConstructor(beanClass);
            MyInterceptor interceptor = null;
            try {
                interceptor = new MyInterceptor(beanClass.newInstance());
            } catch (Exception e) {

            }
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(beanClass);
            enhancer.setCallback(interceptor);
            if (constructor.getParameterTypes().length == 0) {
                return enhancer.create();
            }
            return enhancer.create(constructor.getParameterTypes(), new Object[constructor.getParameterTypes().length]);
        }
        return null;
    }

    private Constructor<?> findConstructor(Class<?> beanClass) {
        Constructor<?>[] constructors = beanClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if (0 == constructor.getParameterTypes().length) {
                return constructor;
            }
        }
        return constructors[0];
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(beanName.equals("lifeCycle")) {
            System.out.println("MyInstantiationAwareBeanPostProcessor  after");
        }
        return true;
    }

    static class MyInterceptor implements MethodInterceptor {

        public Object target;

        public MyInterceptor(Object target) {
            this.target = target;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("method execute before");
            val result = method.invoke(target, objects);
            System.out.println("method execute after");
            return result;
        }
    }
}
