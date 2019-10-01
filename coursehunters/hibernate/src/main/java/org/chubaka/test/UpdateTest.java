package org.chubaka.test;

import org.chubaka.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateTest {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sf.getCurrentSession();

        Student student = new Student("Jane", "Doe", "j@mail.org");

        try {
            //create
            System.out.println("start transaction for writing");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            System.out.println("after writing " + student);
            //update
            session = sf.getCurrentSession();
            session.beginTransaction();
            Student demoStudent = session.get(Student.class, student.getId());
            demoStudent.setFirstName("Marry");
            session.getTransaction().commit();
            //check updating
            session = sf.getCurrentSession();
            session.beginTransaction();
            demoStudent = session.get(Student.class, demoStudent.getId());
            session.getTransaction().commit();
            System.out.println("after updating " + demoStudent);
            //query with update
            session = sf.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set firstName = 'Olya' where lastName = 'Doe'")
                    .executeUpdate();
            session.getTransaction().commit();
        } finally {
            System.out.println("close factory");
            sf.close();
        }
    }
}
