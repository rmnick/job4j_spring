package ru.job4j.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.job4j.item.User;

import java.util.List;

@Component
public class UserStorage {
    private IStorage storage;

    @Autowired
    public UserStorage(IStorage storage) {
        this.storage = storage;
    }

    public User add(User user) {
        return (User) this.storage.add(user);
    }

    public User get(User user) {
        return (User) this.storage.get(user);
    }

    public List<User> getAll() {
        return (List<User>) this.storage.getAll();
    }
}
