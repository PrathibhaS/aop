package com.learn.aop.aspect;

import com.learn.aop.exception.ObjectNotFoundException;
import com.learn.aop.model.Person;
import com.learn.aop.service.IPersonService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component //adding this because this class needs to be bean to be detected
public class LoggingAspect {

    private static Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);

    @Autowired
    private IPersonService personService;

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

    @Before("@annotation(com.learn.aop.annotation.CheckIfExists)")
    public void logObjectBeforeDeletion(JoinPoint jpt) throws ObjectNotFoundException {
        Object[] args = jpt.getArgs();
        LOG.debug("Calling method: {} with ID: {}", jpt.getSignature(), args[0]);
        Person p = personService.getPerson((int) args[0]);
        if(p == null)
            throw new ObjectNotFoundException();
        else
            LOG.debug("Object to be deleted: {}", p);
    }

    @Pointcut("within(com.learn.aop.controller.PersonController.getPerson(..)")
    private void cachePointcut() {}

}
