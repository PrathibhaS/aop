package com.learn.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component //adding this because this class needs to be bean to be detected
public class LoggingAspect {

    private static Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.learn.aop.controller.PersonController.*(..))")
    public Object addLoggers(ProceedingJoinPoint pjp) throws Throwable {
        LOG.debug("Starting execution of {}.", pjp.getSignature());
        Object[] methodArgs = pjp.getArgs();
        if(methodArgs.length>0)
            LOG.debug("Request {}.", methodArgs[0]);
        Date d =  new Date();
        Object result = pjp.proceed();
        int time = (int) (new Date().getTime() - d.getTime());
        LOG.debug("Finished execution of {}. Response: {} \n Time taken to execute: {} ms", pjp.getSignature(),
                result, time);

        return result;

    }

    @Before("@annotation(com.learn.aop.annotation.Log)")
    public void logObjectBeforeDeletion() {
        LOG.debug("Calling delete method");
    }
}
