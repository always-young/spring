package com.kevin.sourceaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Code is far away from bug with the animal protecting
 *
 * @author kevin lau (双鹰)
 */
@Aspect
public class AspectConfig {

    @Pointcut("execution(* sendMessage(*))")
    public void sendMessage() {

    }

    @Around(value = "sendMessage()")
    public Object messageInterceptor(ProceedingJoinPoint joinPoint) {
        System.out.println("执行前");
        try {
            final Object proceed = joinPoint.proceed();
            System.out.println("执行完了");
            return proceed;
        } catch (Throwable e) {
            return null;
        }
    }

}
