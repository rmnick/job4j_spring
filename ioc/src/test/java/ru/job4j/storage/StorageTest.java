package ru.job4j.storage;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.item.User;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class StorageTest {
    @Test
    public void whenLoadContextThenGetBeanMemory() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        MemoryStorage memoryStorage = context.getBean(MemoryStorage.class);
        assertNotNull(memoryStorage);
    }

    @Test
    public void whenLoadContextThenGetBeanStorage() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage userStorage = context.getBean(UserStorage.class);
        User user = new User("Slava");
        int id = userStorage.add(user).getId();
        assertThat(user.getName(), is(userStorage.get(new User(id)).getName()));
    }
}
