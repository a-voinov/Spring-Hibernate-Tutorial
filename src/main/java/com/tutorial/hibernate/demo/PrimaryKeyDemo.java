package com.tutorial.hibernate.demo;

import com.tutorial.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                new Configuration().
                        configure().
                        addAnnotatedClass(Student.class).
                        buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            Student student1 = new Student("Paul","Wall","paul@mail.com");
            Student student2 = new Student("Mary","Public","mary@mail.com");
            Student student3 = new Student("Bonita","Applebum","bonita@mail.com");
            session.beginTransaction();
            int id1 = (int)session.save(student1);
            int id2 = (int)session.save(student2);
            int id3 = (int)session.save(student3);
            System.out.println(id1);
            System.out.println(id2);
            System.out.println(id3);
            session.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
