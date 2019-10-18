package org.chubaka.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainAop {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AopConfig.class);

        DaoExample example = context.getBean("daoExample", DaoExample.class);

        //before
        example.doSomethingUseful();
        example.doSomethingMore();
        example.doSomethingWithArguments("hey", true);

        //after
        List<String> list = example.getSomeStrings();
        list.forEach(System.out :: println);

        //after throwing
        try {
            example.doException(true);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        context.close();

    }
}
