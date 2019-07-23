package ru.job4j.storage;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.function.Function;

public abstract class AbstractHibernateStore<V> implements IStorage<V> {
    private final static Logger LOG = Logger.getLogger(AbstractHibernateStore.class.getName());
    protected SessionFactory sf;

    protected <T> T tx(final Function<Session, T> command) {
        T result = null;
        final Session session = sf.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            result = command.apply(session);
            tx.commit();
        } catch (final Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public V add(V item) {
        return tx(session -> {
            session.save(item);
            return item;
        });
    }

    public V delete(V item) {
        return tx(session -> {
            session.delete(item);
            return item;
        });
    }

    public V update(V item) {
        return tx(session -> {
            session.update(item);
            return item;
        });
    }
}
