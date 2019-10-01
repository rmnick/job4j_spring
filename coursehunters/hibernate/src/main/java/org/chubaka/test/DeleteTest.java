package org.chubaka.test;

import org.chubaka.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteTest {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sf.getCurrentSession();

        Student student = new Student("Bob", "Marley", "b@mail.org");

        try {
            //create
            System.out.println("start transaction for writing");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            System.out.println("after writing " + student);
            //delete
            session = sf.getCurrentSession();
            session.beginTransaction();
            Student demoStudent = session.get(Student.class, student.getId());
            session.delete(demoStudent);
            session.getTransaction().commit();
            //delete with query
            session = sf.getCurrentSession();
            session.beginTransaction();
            session.createQuery("delete from Student s where s.firstName = 'Olya'")
                    .executeUpdate();
            session.getTransaction().commit();
        } finally {
            System.out.println("close factory");
            sf.close();
        }
    }
}
