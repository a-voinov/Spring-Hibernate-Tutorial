package com.tutorial.hibernate.adv.mappings.one2many;

import com.tutorial.hibernate.adv.mappings.one2many.domain.Course;
import com.tutorial.hibernate.adv.mappings.one2many.domain.Instructor;
import com.tutorial.hibernate.adv.mappings.one2many.domain.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {
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
            System.out.println(instructor);
            for (Course course : instructor.getCourses()) {
                System.out.println(course);
            }
            session.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
