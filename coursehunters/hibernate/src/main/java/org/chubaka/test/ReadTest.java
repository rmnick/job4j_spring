package org.chubaka.test;

import org.chubaka.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadTest {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sf.getCurrentSession();

        Student student = new Student("John", "Doe", "d@mail.org");

        try {
            //create
            System.out.println("before writing " + student);
            System.out.println("start transaction for writing");
            session.beginTransaction();
            session.save(student);
            System.out.println("commit transaction");
            session.getTransaction().commit();
            System.out.println("after writing " + student);
            //read
            session = sf.getCurrentSession();
            session.beginTransaction();
            Student demoStudent = session.get(Student.class, student.getId());
            session.getTransaction().commit();
            System.out.println("after reading " + demoStudent);
        } finally {
            System.out.println("close factory");
            sf.close();
        }
    }
}
