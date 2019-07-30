package ru.job4j.service;

import org.springframework.stereotype.Component;
import ru.job4j.service.entities.User;
import ru.job4j.storage.HibernateUserStore;

import java.util.List;

@Component("userService")
public class UserService implements IService<User> {
    private HibernateUserStore hibernateUserStore = HibernateUserStore.getInstance();

    public UserService() {
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

    @Override
    public List<User> getAllBoth() {
        return this.hibernateUserStore.getAllWithMessages();
    }

    @Override
    public boolean check(User user) {
        boolean result = false;
        if (this.hibernateUserStore.getByRestriction(user).size() != 0) {
            result = true;
        }
        return result;
    }
}
