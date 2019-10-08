package org.chubaka.test;

import org.chubaka.entities.Cat;
import org.chubaka.entities.Info;
import org.chubaka.entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ManyToOneLazyOption {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Info.class)
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Cat.class)
                .buildSessionFactory();

        Person person = new Person();
        List<Cat> cats;
        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            int personId = 2;
            person = session.get(Person.class, personId);
            //show person
            System.out.println(person);
            //get data on demand(lazy) in session
            cats = person.getCats();
            //show cats
            cats.forEach(System.out :: println);

            //hql option
            /*
            Query<Person> query = session.createQuery("SELECT p FROM Person p JOIN FETCH p.cats where p.id =: person_id", Person.class);
            query.setParameter("person_id", personId);
            person = query.getSingleResult();
            System.out.println(person);
            */
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("close factory");
            sf.close();
        }
        //after closing session
        person.getCats().forEach(System.out :: println);
    }
}
