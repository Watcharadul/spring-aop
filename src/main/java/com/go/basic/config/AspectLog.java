package com.go.basic.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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

}
