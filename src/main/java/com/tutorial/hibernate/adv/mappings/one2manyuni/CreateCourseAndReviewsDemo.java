package com.tutorial.hibernate.adv.mappings.one2manyuni;

import com.tutorial.hibernate.adv.mappings.one2manyuni.domain.Course;
import com.tutorial.hibernate.adv.mappings.one2manyuni.domain.Instructor;
import com.tutorial.hibernate.adv.mappings.one2manyuni.domain.InstructorDetail;
import com.tutorial.hibernate.adv.mappings.one2manyuni.domain.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {
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
            Course course = new Course("Pacman - How To Score One Million Points");
            course.addReview(new Review("Great course !"));
            course.addReview(new Review("Cool course !"));
            course.addReview(new Review("What an awful course, you are an idiot!"));
            session.save(course);
            session.getTransaction().commit();
            System.out.println(course);
            System.out.println(course.getReviews());
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
