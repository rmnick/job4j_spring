package ru.job4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.service.ConsoleInput;
import ru.job4j.service.Dispatcher;
import ru.job4j.service.IInput;
import ru.job4j.storage.UserStorage;

import java.util.StringJoiner;

public class ImportUser {
    private final UserStorage userStorage;
    private final IInput input;
    private boolean exit = false;
    public final static String ADD = "1.add user";
    public final static String GET = "2.get user";
    public final static String SHOW = "3.show user";
    public final static String EXIT = "4.exit";
    public final static String ACTION = "please select menu item: ";
    public final static String MENU = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
            .add(ADD)
            .add(GET)
            .add(SHOW)
            .add(EXIT)
            .add(ACTION)
            .toString();

    public ImportUser(UserStorage userStorage, IInput input) {
        this.userStorage = userStorage;
        this.input = input;
    }


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage userStorage = context.getBean(UserStorage.class);
        IInput consoleInput = new ConsoleInput();
        ImportUser iu = new ImportUser(userStorage, consoleInput);
        Dispatcher dispatcher = new Dispatcher(iu);
        iu.start(dispatcher);
    }

    public void start(Dispatcher dispatcher) {
        do {
            System.out.println(MENU);
            String answer = input.answer();
            dispatcher.handle(answer);
        } while (!exit);
    }

    public void exit() {
        this.exit = true;
    }

    public UserStorage getUserStorage() {
        return this.userStorage;
    }

    public IInput getInput() {
        return this.input;
    }

}
