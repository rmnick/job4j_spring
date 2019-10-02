package org.chubaka.test;

import org.chubaka.entities.Info;
import org.chubaka.entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneTest {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Info.class)
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();
        Session session = sf.getCurrentSession();

        Person person = new Person("Nick", "Rodionov", "k@mail.org");
        Info info = new Info("bicycle", true);
        person.setInfo(info);

        try {
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        } finally {
            System.out.println("close factory");
            sf.close();
        }
    }
}
