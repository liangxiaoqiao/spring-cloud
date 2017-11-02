package com.lc.spring.db.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by LC on 2017/11/2.
 */
@Aspect
@Component
public class Advice {
    @Pointcut("@annotation(MyAnno)")
    public void myPointCut(){

    }

    @After("myPointCut()")
    public void after(){
        System.out.println("After 执行");
    }

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
