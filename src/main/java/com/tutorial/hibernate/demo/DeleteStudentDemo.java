package com.tutorial.hibernate.demo;

import com.tutorial.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                new Configuration().
                configure().
                addAnnotatedClass(Student.class).
                buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            int studentId = 1;
            session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            session.delete(student);
            session.getTransaction().commit();
            //query delete
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("delete Student s where s.id=2").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
