package ru.job4j.storage;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import ru.job4j.service.entities.Message;
import ru.job4j.service.entities.User;

import java.util.ArrayList;
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

    @Override
    public List<Message> getByRestriction(Message message) {
        return new ArrayList<Message>();
    }

    public List<Message> getAllWithUsers() {
        return tx(session -> {
            Query query = session.createQuery("select m from Message m inner join fetch User");
            return query.list();
        });
    }

}
