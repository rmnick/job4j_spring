package org.chubaka.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAop {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AopConfig.class);

        DaoExample example = context.getBean("daoExample", DaoExample.class);

        example.doSomethingUseful();

        context.close();
    }
}
