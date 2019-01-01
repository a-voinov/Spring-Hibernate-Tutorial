package com.tutorial.hibernate.adv.mappings.one2one;

import com.tutorial.hibernate.adv.mappings.one2one.domain.Instructor;
import com.tutorial.hibernate.adv.mappings.one2one.domain.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                new Configuration().
                configure("/hibernate-tutorial/hibernate-one-to-one.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            int id = 1;
            //associate the objects
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println(instructor);
            if (instructor != null) {
                session.delete(instructor);
                System.out.println("Instructor deleted");
            } else
                System.out.println("Instructor not found");
            session.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
