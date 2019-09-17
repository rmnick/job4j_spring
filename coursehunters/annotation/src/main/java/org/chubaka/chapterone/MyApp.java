package org.chubaka.chapterone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("chapterOne-context.xml");
        ICoach swimCoach = context.getBean("SwimCoach", ICoach.class);
        ICoach runCoach = context.getBean("RunCoach", ICoach.class);
    }
}
