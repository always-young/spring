package com.kevin.sourceaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Code is far away from bug with the animal protecting
 *
 * @author kevin lau (双鹰)
 */
public class LogInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("method execute start");
        Object result = invocation.proceed();
        long end = System.currentTimeMillis();
        System.out.println("method execute end 耗时:" + (end - start));
        return result;
    }
}
