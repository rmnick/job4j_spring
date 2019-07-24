package ru.job4j.storage;

import ru.job4j.service.entities.Message;
import ru.job4j.service.entities.User;

import java.util.List;

public class MessageStorage {
    private IStorage<Message> storage;

    public MessageStorage(IStorage<Message> storage) {
        this.storage = storage;
    }

    public Message add(Message message) {
        return this.storage.add(message);
    }

    public Message update(Message message) {
        return this.storage.update(message);
    }

    public Message delete(Message message) {
        return this.storage.delete(message);
    }
}
