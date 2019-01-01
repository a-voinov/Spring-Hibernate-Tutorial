package com.tutorial.hibernate.demo;

import com.tutorial.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                new Configuration().
                configure().
                addAnnotatedClass(Student.class).
                buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            List<Student> studentList = session.createQuery("from Student", Student.class)
                    .getResultList();
            printStudents(studentList);
            studentList = session.createQuery("from Student s where s.lastName='Doe'", Student.class)
                            .getResultList();
            printStudents(studentList);
            session.getTransaction().commit();



        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }

    private static void printStudents(List<Student> studentList) {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
