package com.tutorial.hibernate.adv.mappings.one2many;

import com.tutorial.hibernate.adv.mappings.one2many.domain.Course;
import com.tutorial.hibernate.adv.mappings.one2many.domain.Instructor;
import com.tutorial.hibernate.adv.mappings.one2many.domain.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
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
            Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
            InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "luv2code");
            //associate the objects
            instructor.setInstructorDetail(instructorDetail);
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();
            //out instructor
            System.out.println(instructor);
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
