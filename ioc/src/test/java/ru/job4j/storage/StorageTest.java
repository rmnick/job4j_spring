package ru.job4j.storage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.ImportUser;
import ru.job4j.item.User;
import ru.job4j.service.Dispatcher;
import ru.job4j.service.IInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class StorageTest {
    private final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Test
    public void whenLoadContextThenGetBeanMemory() {
        MemoryStorage memoryStorage = (MemoryStorage) applicationContext.getBean("memory");
        assertNotNull(memoryStorage);
    }

    @Test
    public void whenLoadContextThenGetBeanStorage() {
        UserStorage userStorage = (UserStorage) applicationContext.getBean("dao");
        assertNotNull(userStorage);
    }

    @Test
    public void whenAddUserThenAddingUserToMemory() {
        UserStorage userStorage = (UserStorage) applicationContext.getBean("dao");
        User user = new User("Slava");
        User result = userStorage.add(user);
        assertThat(user.getName(), is(userStorage.get(result).getName()));
    }

    @Test
    public void whenGetUserFromMemoryByIdThenReturnRightUserFromMemory() {
        UserStorage userStorage = (UserStorage) applicationContext.getBean("dao");
        User user = new User("Sergei");
        User result = userStorage.add(user);
        assertThat(result, is(userStorage.get(result)));
    }

    @Test
    public void whenGetAllUsersThenReturnAllFromMemory() {
        UserStorage userStorage = (UserStorage) applicationContext.getBean("dao");
        User userOne = new User("Slava");
        User userTwo = new User("Sergei");
        userStorage.add(userOne);
        userStorage.add(userTwo);
        assertThat(userStorage.getAll().size(), is(2));
    }

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenAddUserFromImportUserThenAddingUserToMemory() {
        UserStorage userStorage = (UserStorage) applicationContext.getBean("dao");
        List<String> answers = new ArrayList<>();
        answers.add("1");
        answers.add("Slava");
        answers.add("4");
        IInput testInput = new TestInput(answers);
        ImportUser iu = new ImportUser(userStorage, testInput);
        Dispatcher dispatcher = new Dispatcher(iu);
        iu.start(dispatcher);
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                .append(ImportUser.MENU)
                .append(System.lineSeparator())
                .append("please enter a name: ")
                .append(System.lineSeparator())
                .append("User{id : 1; name : Slava} was added")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(ImportUser.MENU)
                .append(System.lineSeparator())
                .append("exit")
                .append(System.lineSeparator()).toString()));
    }

    @Test
    public void whenGetUserFromImportUserThenReturnUserFromMemory() {
        UserStorage userStorage = (UserStorage) applicationContext.getBean("dao");
        List<String> answers = new ArrayList<>();
        answers.add("1");
        answers.add("Slava");
        answers.add("2");
        answers.add("1");
        answers.add("4");
        IInput testInput = new TestInput(answers);
        ImportUser iu = new ImportUser(userStorage, testInput);
        Dispatcher dispatcher = new Dispatcher(iu);
        iu.start(dispatcher);
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                .append(ImportUser.MENU)
                .append(System.lineSeparator())
                .append("please enter a name: ")
                .append(System.lineSeparator())
                .append("User{id : 1; name : Slava} was added")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(ImportUser.MENU)
                .append(System.lineSeparator())
                .append("please enter id: ")
                .append(System.lineSeparator())
                .append("User{id : 1; name : Slava}")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(ImportUser.MENU)
                .append(System.lineSeparator())
                .append("exit")
                .append(System.lineSeparator()).toString()));
    }

    @Test
    public void whenGetAllUserFromImportUserThenReturnAllUsersFromMemory() {
        UserStorage userStorage = (UserStorage) applicationContext.getBean("dao");
        List<String> answers = new ArrayList<>();
        answers.add("1");
        answers.add("Slava");
        answers.add("3");
        answers.add("4");
        IInput testInput = new TestInput(answers);
        ImportUser iu = new ImportUser(userStorage, testInput);
        Dispatcher dispatcher = new Dispatcher(iu);
        iu.start(dispatcher);
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                .append(ImportUser.MENU)
                .append(System.lineSeparator())
                .append("please enter a name: ")
                .append(System.lineSeparator())
                .append("User{id : 1; name : Slava} was added")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(ImportUser.MENU)
                .append(System.lineSeparator())
                .append("User{id : 1; name : Slava}")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(ImportUser.MENU)
                .append(System.lineSeparator())
                .append("exit")
                .append(System.lineSeparator()).toString()));
    }


}
