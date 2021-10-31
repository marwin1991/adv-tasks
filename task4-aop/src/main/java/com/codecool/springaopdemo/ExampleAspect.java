package com.codecool.springaopdemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleAspect {


    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        for (Object arg: joinPoint.getArgs()) {
            System.out.println(arg);
        }

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        System.out.println(proceed);

        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }

}