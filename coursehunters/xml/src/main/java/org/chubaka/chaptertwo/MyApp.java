package org.chubaka.chaptertwo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("scope-context.xml");
        ISinger rockOne = context.getBean("rock", ISinger.class);
        ISinger rockTwo = context.getBean("rock", ISinger.class);
        ISinger operaOne = context.getBean("opera", ISinger.class);
        ISinger operaTwo = context.getBean("opera", ISinger.class);
        System.out.println(String.format("true %b", rockOne == rockTwo));
        System.out.println(String.format("false %b", operaOne == operaTwo));
        context.close();
    }
}
