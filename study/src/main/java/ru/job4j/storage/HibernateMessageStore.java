package ru.job4j.storage;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import ru.job4j.service.entities.Message;

import java.util.List;

public class HibernateMessageStore extends AbstractHibernateStore<Message> {
    private final static HibernateMessageStore INSTANCE = new HibernateMessageStore();

    public static HibernateMessageStore getInstance() {
        return INSTANCE;
    }

    private HibernateMessageStore() {
        sf = HibernateSessionFactoryUtil.getFactory();
    }


    public Message get(Message item) {
        return tx(session -> {
            return session.get(Message.class, item.getId());
        });
    }

    @Override
    public List<Message> getAll() {
        return tx(session -> {
            Criteria criteria = session.createCriteria(Message.class);
            criteria.addOrder(Order.asc("id"));
            return criteria.list();
        });
    }
}
