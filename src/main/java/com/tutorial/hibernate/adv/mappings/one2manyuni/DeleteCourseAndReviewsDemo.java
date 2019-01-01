package com.tutorial.hibernate.adv.mappings.one2manyuni;

import com.tutorial.hibernate.adv.mappings.one2manyuni.domain.Course;
import com.tutorial.hibernate.adv.mappings.one2manyuni.domain.Instructor;
import com.tutorial.hibernate.adv.mappings.one2manyuni.domain.InstructorDetail;
import com.tutorial.hibernate.adv.mappings.one2manyuni.domain.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                new Configuration().
                configure("/hibernate-tutorial/hibernate-one-to-many-uni.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Review.class).
                buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            int id = 10;
            Course course = session.get(Course.class, id);
            session.delete(course);
            session.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
