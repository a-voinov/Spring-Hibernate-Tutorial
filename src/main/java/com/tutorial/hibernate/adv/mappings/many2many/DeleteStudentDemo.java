package com.tutorial.hibernate.adv.mappings.many2many;

import com.tutorial.hibernate.adv.mappings.many2many.domain.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
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

            int id = 2;
            Student student = session.get(Student.class, id);
            System.out.println("Deleting student : " + student);
            System.out.println(student.getCourses());
            session.delete(student);
            session.getTransaction().commit();

        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
