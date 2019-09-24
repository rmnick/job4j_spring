package org.chubaka.javacode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CoachConfig.class);

        ICoach swimCoach = context.getBean("runCoach", ICoach.class);
        ICoach runCoach = context.getBean("swimCoach", ICoach.class);
        System.out.println(swimCoach.prepare());
        System.out.println(swimCoach.work());
        System.out.println(runCoach.prepare());
        System.out.println(runCoach.work());

        System.out.println(swimCoach);
        System.out.println(runCoach);

        context.close();
    }
}
