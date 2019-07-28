package ru.job4j.service;

import org.springframework.stereotype.Component;
import ru.job4j.service.entities.Message;
import ru.job4j.storage.HibernateMessageStore;

import java.util.List;

@Component
public class MessageService implements IService<Message> {
    private HibernateMessageStore store = HibernateMessageStore.getInstance();

    public MessageService() {
    }

    @Override
    public Message add(Message item) {
        return this.store.add(item);
    }

    @Override
    public Message get(Message item) {
        return this.store.get(item);
    }

    @Override
    public Message update(Message item) {
        return this.store.update(item);

    }

    @Override
    public Message delete(Message item) {
        return this.store.delete(item);
    }

    @Override
    public List<Message> getAll() {
        return this.store.getAll();
    }

    @Override
    public List<Message> getAllBoth() {
        return this.store.getAllWithUsers();
    }
}
