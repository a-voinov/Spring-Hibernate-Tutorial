package com.tutorial.hibernate.adv.mappings.one2one2directional;

import com.tutorial.hibernate.adv.mappings.one2one.domain.Instructor;
import com.tutorial.hibernate.adv.mappings.one2one.domain.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                new Configuration().
                configure("/hibernate-tutorial/hibernate-one-to-one.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            int id = 2;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println(instructorDetail.getInstructor());
            session.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
