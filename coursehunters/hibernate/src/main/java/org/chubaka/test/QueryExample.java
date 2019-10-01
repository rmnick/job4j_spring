package org.chubaka.test;

import org.chubaka.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryExample {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sf.getCurrentSession();
        try {
          //get list of entities from DB
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student").list();
            session.getTransaction().commit();
            students.forEach(System.out::println);

            session = sf.getCurrentSession();
            session.beginTransaction();
            students = session.createQuery("from Student s where s.firstName = 'Nick'").list();
            session.getTransaction().commit();
            students.forEach(System.out::println);

        } finally {
            System.out.println("close factory");
            sf.close();
        }
    }
}
