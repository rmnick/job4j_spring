package ru.job4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.item.User;
import ru.job4j.storage.UserStorage;

import java.util.Scanner;

public class ImportUser {
    private final static String ADD = "1.add user";
    private final static String GET = "2.get user";
    private final static String SHOW = "3.show user";
    private final static String EXIT = "4.exit";
    private final static String MENU = String.format(
            "%s%s%s%s%s%s%S",
            ADD,
            System.lineSeparator(),
            GET,
            System.lineSeparator(),
            SHOW,
            System.lineSeparator(),
            EXIT
    );
    private final static String ACTION = "please select menu item: ";



    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        User user;
        Scanner sc = new Scanner(System.in);
        System.out.println(MENU);
        System.out.println(ACTION);
        String answer = sc.nextLine();
        while (!answer.equals("4")) {
            switch (answer) {
                case "1" :
                    System.out.println("input name: ");
                    String name = sc.nextLine();
                    user = new User(name);
                    user = context.getBean(UserStorage.class).add(user);
                    System.out.println(String.format("user with id = %s and name \"%s\" was added to DB", user.getId(), user.getName()));
                    break;
                case "2" :
                    System.out.println("input id: ");
                    String id = sc.nextLine();
                    user = new User(Integer.valueOf(id));
                    user = context.getBean(UserStorage.class).get(user);
                    System.out.println(user.getName());
                    break;
                default:
                    System.out.println("input something right");
                    break;
            }
            System.out.println(MENU);
            System.out.println(ACTION);
            answer = sc.nextLine();
        }
    }
}
