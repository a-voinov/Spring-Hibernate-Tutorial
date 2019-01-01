package com.tutorial.hibernate.demo;

import com.tutorial.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                new Configuration().
                configure().
                addAnnotatedClass(Student.class).
                buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            Student student = new Student("Jim","Halpert","jim@mail.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Student was saved. Generated id : " + student.getId());

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Student oldStudent = session.get(Student.class, student.getId());
            System.out.println(oldStudent);
            session.getTransaction().commit();

        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
