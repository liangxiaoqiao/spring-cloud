package com.lc.spring.db.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by LC on 2017/11/2.
 */
@Aspect
@Component
public class Advice {

    @AfterReturning("@annotation(MyAnno)")
    public void afterReturn(JoinPoint joinPoint) throws Throwable {
        joinPoint.getArgs();
        System.out.println("After Returnning 执行");
    }
    @Before("@annotation(MyAnno)")
    public void before(){
        System.out.println("Before 执行");
    }
}
