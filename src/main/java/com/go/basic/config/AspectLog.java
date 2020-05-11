package com.go.basic.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class AspectLog {

    @Before("execution(* com.go.basic.service.*.*(..))")
    public void callBefore(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature()+" (Before)");
    }

    @After("execution(* com.go.basic.service.*.*(..))")
    public void callAfter(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature()+" (After)");
    }

    @Around("execution(* com.go.basic.controller.*.*(..))")
    public String callAround(ProceedingJoinPoint proceed) throws Throwable {
        log.info(proceed.getSignature()+" (Around)");
        return "Around : "+proceed.proceed();
    }

    @AfterReturning(pointcut = "execution(* com.go.basic.service.*.*(..))", returning="value")
    public void callReturn(Object value){
        log.info("My Returning : "+value);
    }

    @AfterThrowing(pointcut = "execution(* com.go.basic.service.*.*(..))", throwing = "exception")
    public void callError(JoinPoint joinPoint, Exception exception){
        log.error("My Error : ",exception.getMessage());
    }

}
