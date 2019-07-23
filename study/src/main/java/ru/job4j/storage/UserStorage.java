package ru.job4j.storage;

import ru.job4j.service.entities.User;

public class UserStorage {

    private IStorage<User> storage;

    public UserStorage(IStorage<User> storage) {
        this.storage = storage;
    }

    public User add(User user) {
        return this.storage.add(user);
    }

    public User get(User user) {
        return this.storage.get(user);
    }

    public User update(User user) {
        return this.storage.update(user);
    }

    public User delete(User user) {
        return this.storage.delete(user);
    }



}
