package ru.job4j.service;

import ru.job4j.ImportUser;
import ru.job4j.item.User;

import java.util.*;

/**
 * class for dispatching answer from user
 */
public class Dispatcher {
    private ImportUser iu;
    private final static String FALSE = "please enter correct number";
    private final Map<String, IHandler> map = new HashMap<>();

    public Dispatcher(ImportUser iu) {
        this.iu = iu;
        init();
    }

    private void init() {
        this.map.put("1", new Add());
        this.map.put("2", new Get());
        this.map.put("3", new GetAll());
        this.map.put("4", new Exit());
    }

    /**
     * processing answers from user
     * @param answer String from user console
     */
    public void handle(String answer) {
        if (map.get(answer) == null) {
            System.out.println(FALSE);
        } else {
            this.map.get(answer).handle();
        }

    }

    private class Add implements IHandler {
        public void handle() {
            System.out.println("please enter a name: ");
            String answer = iu.getInput().answer();
            User user = new User(answer);
            user = iu.getUserStorage().add(user);
            System.out.println(String.format("%s was added%s", user.toString(), System.lineSeparator()));
        }
    }

    private class Get implements IHandler {
        public void handle() {
            System.out.println("please enter id: ");
            String answer = iu.getInput().answer();
            int id;
            try {
                id = Integer.valueOf(answer);
            } catch (NumberFormatException e) {
                System.out.println("incorrect id");
                System.out.println();
                return;
            }
            User user = new User(id);
            user = iu.getUserStorage().get(user);
            System.out.println(String.format("%s%s", user.toString(), System.lineSeparator()));
        }
    }

    private class GetAll implements IHandler {
        public void handle() {
            List<User> result = iu.getUserStorage().getAll();
            result.forEach(System.out::println);
            System.out.println();
        }
    }

    private class Exit implements IHandler {
        public void handle() {
            System.out.println("exit");
            iu.exit();
        }
    }



}
