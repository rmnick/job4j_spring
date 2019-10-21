package org.chubaka.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * for example logging with aspectJ
 */
@Aspect
@Component
public class LoggerExmpl {

    private final static Logger LOG = Logger.getLogger(LoggerExmpl.class.getName());

    @Pointcut("execution(* org.chubaka.controller.*.*(..))")
    public void controllerPoint() { }

    @Pointcut("execution(* org.chubaka.dao.*.*(..))")
    public void daoPoint() { }

    @Pointcut("execution(* org.chubaka.service.*.*(..))")
    public void servicePoint() { }

    @Pointcut("controllerPoint() || daoPoint() || servicePoint()")
    public void appPoint() { }

    @Before("appPoint()")
    public void testLog(JoinPoint joinPoint) {
        LOG.info("before method is " + joinPoint.getSignature().toShortString());
        LOG.info("args before method are: ");
        Arrays.stream(joinPoint.getArgs()).forEach(LOG :: info);
    }

    @AfterReturning(value = "appPoint()", returning = "result")
    public void testLogAfter(JoinPoint joinPoint, Object result) {
        LOG.info("after method is " + joinPoint.getSignature().toShortString());
        LOG.info("result after method is: " + result);
    }
}
