package org.chubaka.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
@Order(2)
public class SecondDemoAspect {
    @Pointcut("execution(public * org.chubaka.aop.*.*(..))")
    private void doBeforDoSomething(){};

    @Pointcut("execution(public void org.chubaka.aop.DaoExample.doSomethingMore())")
    private void doBeforeDoSomethingMore(){};

    //use pointcut definition and logical express
    @Before("doBeforDoSomething() && !(doBeforeDoSomethingMore())")
    public void anotherBeforExample() {
        System.out.println("do something again");
    }

    //read arguments from signature
    @Before("execution(public void org.chubaka.aop.DaoExample.doSomethingWithArguments(*, *))")
    public void doSomethingWithArgs(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("method signature: " + signature);
        Object[] arg = joinPoint.getArgs();
        System.out.println(String.format("argOne is %s, argTwo is %s", String.valueOf(arg[0]), String.valueOf(arg[1])));
    }

    @AfterReturning(value = "execution(* org.chubaka.aop.*.*(..))", returning = "result")
    public void doSomeWithResult(JoinPoint joinPoint, List<String> result) {
        System.out.println("result method " + joinPoint.getSignature());
        //before change
        result.forEach(System.out :: println);
        //change result
        result.add("third");
    }
}
