package org.chubaka.chapterone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("chapterone-context.xml");

        ICoach swimCoach = context.getBean("swim", ICoach.class);
        //default definition
        ICoach runCoach = context.getBean("runCoach", ICoach.class);
        //run coach starts earlier because there's using postConstruct
        System.out.println(swimCoach.prepare());
        System.out.println(swimCoach.work());
        System.out.println(runCoach .prepare());
        System.out.println(runCoach .work());

        context.close();
        //there's method after destroy runCoach bean
    }
}
