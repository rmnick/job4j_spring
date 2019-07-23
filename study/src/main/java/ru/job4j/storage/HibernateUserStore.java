package ru.job4j.storage;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import ru.job4j.service.entities.User;

import java.util.List;

public class HibernateUserStore extends AbstractHibernateStore<User> {
    private final static HibernateUserStore INSTANCE = new HibernateUserStore();

    private HibernateUserStore() {
        sf = HibernateSessionFactoryUtil.getFactory();
    }

    public static HibernateUserStore getInstance() {
        return INSTANCE;
    }

    @Override
    public User get(User item) {
        return tx(session -> {
            return session.get(User.class, item.getId());
        });
    }

    @Override
    public List<User> getAll() {
        return tx(session -> {
            Criteria criteria = session.createCriteria(User.class);
            criteria.addOrder(Order.asc("id"));
            return criteria.list();
        });
    }
}
