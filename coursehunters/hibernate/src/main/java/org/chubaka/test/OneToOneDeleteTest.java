package org.chubaka.test;

import org.chubaka.entities.Info;
import org.chubaka.entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDeleteTest {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Info.class)
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();
        Session session = sf.getCurrentSession();
        Info info;
        try {
            session.beginTransaction();
            info = session.get(Info.class, 2);
            System.out.println(info);
            //delete only info, cascade type excepts remove
            //delete link between person and info
            info.getPerson().setInfo(null);
            //delete info without any links
            session.delete(info);
            session.getTransaction().commit();
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
//            session.close();
            System.out.println("close factory");
            sf.close();
        }
    }
}
