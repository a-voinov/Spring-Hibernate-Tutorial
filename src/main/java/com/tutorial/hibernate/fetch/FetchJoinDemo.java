package com.tutorial.hibernate.fetch;

import com.tutorial.hibernate.adv.mappings.one2many.domain.Course;
import com.tutorial.hibernate.adv.mappings.one2many.domain.Instructor;
import com.tutorial.hibernate.adv.mappings.one2many.domain.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
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

                Query<Instructor> query = session.createQuery("select i from Instructor i " +
                        " JOIN FETCH i.courses where i.id=:instructorId",
                        Instructor.class);
                query.setParameter("instructorId", id);

                Instructor instructor = query.getSingleResult();
                System.out.println(instructor);

            session.getTransaction().commit();

            for (Course course : instructor.getCourses()) {
                System.out.println(course);
            }

        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
