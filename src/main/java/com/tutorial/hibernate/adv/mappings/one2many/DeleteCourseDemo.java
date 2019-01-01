package com.tutorial.hibernate.adv.mappings.one2many;

import com.tutorial.hibernate.adv.mappings.one2many.domain.Course;
import com.tutorial.hibernate.adv.mappings.one2many.domain.Instructor;
import com.tutorial.hibernate.adv.mappings.one2many.domain.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                new Configuration().
                configure("/hibernate-tutorial/hibernate-one-to-many.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).
                buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            int id = 10;
            Course course = session.get(Course.class, id);
            System.out.println(course);
            session.delete(course);
            session.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
