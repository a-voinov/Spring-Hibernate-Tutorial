package com.tutorial.hibernate.adv.mappings.one2many;

import com.tutorial.hibernate.adv.mappings.one2many.domain.Course;
import com.tutorial.hibernate.adv.mappings.one2many.domain.Instructor;
import com.tutorial.hibernate.adv.mappings.one2many.domain.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
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
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);
            Course course1 = new Course("Air Guitar - The Ultimate Guide");
            Course course2 = new Course("Complete Spring And Hibernate Course");
            instructor.add(course1);
            instructor.add(course2);
            session.save(course1);
            session.save(course2);
            session.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
