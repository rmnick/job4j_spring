package org.chubaka.test;

import org.chubaka.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sf.getCurrentSession();

        Student student = new Student("Nick", "Rodionov", "k@mail.org");

        try {
            System.out.println("start transaction");
            session.beginTransaction();
            session.save(student);
            System.out.println("commit transaction");
            session.getTransaction().commit();
        } finally {
            System.out.println("close factory");
            sf.close();
        }
    }
}
