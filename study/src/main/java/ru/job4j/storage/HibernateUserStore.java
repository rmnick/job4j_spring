package ru.job4j.storage;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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

    @Override
    public List<User> getByRestrictionOne(User user) {
        return tx(session -> {
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("login", user.getLogin()))
                    .add(Restrictions.eq("password", user.getPassword()));
            return (List<User>) criteria.list();
        });
    }

    @Override
    public List<User> getByRestrictionTwo(User user) {
        return tx(session -> {
            Criteria criteria = session.createCriteria(User.class);
            Criterion one = Restrictions.eq("login", user.getLogin());
            Criterion two = Restrictions.eq("phone", user.getPhone());
            return (List<User>) criteria.add(Restrictions.or(one, two)).list();
        });
    }

    public List<User> getAllWithMessages() {
        return tx(session -> {
            Query query = session.createQuery("select distinct u from User u inner join fetch u.messageList list order by list.id");
            return query.list();
        });
    }
}
