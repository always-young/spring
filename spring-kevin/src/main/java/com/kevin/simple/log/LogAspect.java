package com.kevin.simple.log;

import lombok.val;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author kevin lau (双鹰)
 */
@Aspect
public class LogAspect {

    @Pointcut("@annotation(com.kevin.simple.log.Log)")
    public void log(){

    }

    @Around("log()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("方法开始执行");
        val obj = joinPoint.proceed();
        System.out.println("方法执行完毕");
        return obj;
    }
}
