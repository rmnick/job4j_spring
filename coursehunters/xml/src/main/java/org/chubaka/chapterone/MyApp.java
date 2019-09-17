package org.chubaka.chapterone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ICoach swimCoach = context.getBean("SwimCoach", ICoach.class);
        ICoach runCoach = context.getBean("RunCoach", ICoach.class);
        System.out.println(swimCoach.getName() + " " + swimCoach.prepare());
        System.out.println("swimming training " + swimCoach.work());
        System.out.println(swimCoach);
        System.out.println(runCoach.getName() + " " + runCoach.prepare());
        System.out.println("running training " + runCoach.work());
        context.close();

    }
}
