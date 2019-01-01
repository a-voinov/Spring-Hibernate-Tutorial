package com.tutorial.hibernate.demo;

import com.tutorial.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                new Configuration().
                configure().
                addAnnotatedClass(Student.class).
                buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            Student student = new Student("Jane","Doe","jane@mail.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
