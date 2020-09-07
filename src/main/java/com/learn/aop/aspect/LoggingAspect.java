package com.learn.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component //adding this because this class needs to be bean to be detected
public class LoggingAspect {

    private static Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.learn.aop.controller.PersonController.*(..))")
    public void addLoggers(ProceedingJoinPoint pjp) throws Throwable {
        LOG.debug("Starting execution of {}", pjp.getArgs());
        pjp.proceed();

    }
}
