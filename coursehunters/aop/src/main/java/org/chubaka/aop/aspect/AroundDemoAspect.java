package org.chubaka.aop.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(4)
public class AroundDemoAspect {
    private final static Logger LOG = Logger.getLogger(AroundDemoAspect.class.getName());

    @Pointcut("execution(public void org.chubaka.aop.DaoExample.doWithDelay(..))")
    public void arroundExmp() { };

    @Around("arroundExmp()")
    public void doWithDelayAspectExmpample(ProceedingJoinPoint joinPoint) {
        LOG.info(joinPoint.getSignature().toString());
        try {
            Object result = joinPoint.proceed();
            LOG.info(result.toString() + "end of proceeding");
        } catch (Throwable e) {
            LOG.error(e.getMessage(), e);
            LOG.info("inside around aspect");
        }
    }
}