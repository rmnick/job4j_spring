package ru.job4j.storage;

import ru.job4j.item.User;

public class UserStorage {
    private IStorage storage;

    public UserStorage(IStorage storage) {
        this.storage = storage;
    }

    public User add(User user) {
        return (User) this.storage.add(user);
    }

    public User get(User user) {
        return (User) this.storage.get(user);
    }
}