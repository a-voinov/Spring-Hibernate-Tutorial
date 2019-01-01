package com.tutorial.hibernate.adv.mappings.many2many;

import com.tutorial.hibernate.adv.mappings.many2many.domain.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                new Configuration().
                        configure("/hibernate-tutorial/hibernate-many-to-many.cfg.xml").
                        addAnnotatedClass(Instructor.class).
                        addAnnotatedClass(InstructorDetail.class).
                        addAnnotatedClass(Course.class).
                        addAnnotatedClass(Review.class).
                        addAnnotatedClass(Student.class).
                        buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            
            int id = 11;
            Course course = session.get(Course.class, id);
            System.out.println("Deleting course" + course);
            session.delete(course);
            session.getTransaction().commit();

        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
