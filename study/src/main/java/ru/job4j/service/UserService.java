package ru.job4j.service;

import ru.job4j.service.entities.User;
import ru.job4j.storage.HibernateUserStore;

import java.util.List;

public class UserService implements IService<User> {
    private HibernateUserStore hibernateUserStore = HibernateUserStore.getInstance();
    private final static UserService INSTANCE = new UserService();

    private UserService() {

    }

    public static UserService getInstance() {
        return INSTANCE;
    }



    public User add(User user) {
        return this.hibernateUserStore.add(user);
    }

    public User get(User user) {
        return this.hibernateUserStore.get(user);
    }

    public User delete(User user) {
        return this.hibernateUserStore.delete(user);
    }

    public User update(User user) {
        return this.hibernateUserStore.update(user);
    }

    public List<User> getAll() {
        return this.hibernateUserStore.getAll();
    }

    public List<User> getAllWithMessages() {
        return this.hibernateUserStore.getAllWithMessages();
    }
}
