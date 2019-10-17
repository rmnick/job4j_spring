package org.chubaka.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoAspect {

    @Before("execution(public void doSomethingUseful())")
    public void doBefore() {
        System.out.println("do some work before the specific method");
    }
}
