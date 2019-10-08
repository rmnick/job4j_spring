package org.chubaka.test;

import org.chubaka.entities.Cat;
import org.chubaka.entities.Info;
import org.chubaka.entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToOneBidirectional {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Info.class)
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Cat.class)
                .buildSessionFactory();

        Person person = new Person("Nick", "Rodionov", "k@mail.org");
        Info info = new Info("bicycle", true);
        person.setInfo(info);

        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            session.save(person);
            Cat one = new Cat("murzik");
            Cat two = new Cat("murka");
            person.addCat(one);
            person.addCat(two);
            session.save(one);
            session.save(two);
            session.getTransaction().commit();
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
            System.out.println("close factory");
            sf.close();
        }
    }
}
