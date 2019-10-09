package org.chubaka.test;


import org.chubaka.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToMany {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Dog.class)
                .addAnnotatedClass(Owner.class)
                .buildSessionFactory();

        try (Session session = sf.getCurrentSession()) {
            Owner owner = new Owner("Vasya", "Pupkin");
            Dog dogOne = new Dog("Chappy");
            Dog dogTwo = new Dog("Trezor");

            session.beginTransaction();
            session.save(owner);
            owner.addDog(dogOne);
            owner.addDog(dogTwo);
            session.save(dogOne);
            session.save(dogTwo);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("close factory");
            sf.close();
        }
    }
}
