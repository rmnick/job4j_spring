package org.chubaka.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class ThirdDemoAspect {

    @AfterThrowing(value = "execution(* *(..))", throwing = "ex")
    public void catchException(JoinPoint joinPoint, Throwable ex) {
        System.out.println(joinPoint);
        System.out.println(ex + " hey from catch aspect block");
    }
}
