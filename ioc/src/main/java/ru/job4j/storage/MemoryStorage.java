package ru.job4j.storage;

import ru.job4j.item.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryStorage implements IStorage<User> {
    private final Map<Integer, User> map = new HashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);


    @Override
    public User add(User user) {
        int id = this.getId();
        user.setId(id);
        this.map.put(id, user);
        return this.map.get(user.getId());
    }

    @Override
    public User get(User user) {
        return this.map.get(user.getId());
    }

    private int getId() {
        return counter.incrementAndGet();
    }

    @Override
    public void close() {

    }


}
