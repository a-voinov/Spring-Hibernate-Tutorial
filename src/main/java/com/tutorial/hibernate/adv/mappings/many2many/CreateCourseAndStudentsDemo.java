package com.tutorial.hibernate.adv.mappings.many2many;

import com.tutorial.hibernate.adv.mappings.many2many.domain.Course;
import com.tutorial.hibernate.adv.mappings.many2many.domain.Instructor;
import com.tutorial.hibernate.adv.mappings.many2many.domain.InstructorDetail;
import com.tutorial.hibernate.adv.mappings.many2many.domain.Review;
import com.tutorial.hibernate.adv.mappings.many2many.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
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
            Course course = new Course("Pacman - How To Score One Million Points");
            session.save(course);
            Student student1 = new Student("Paul","Wall","paul@mail.com");
            Student student2 = new Student("Mary","Public","mary@mail.com");
            Student student3 = new Student("Bonita","Applebum","bonita@mail.com");
            course.addStudent(student1);
            course.addStudent(student2);
            course.addStudent(student3);
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.getTransaction().commit();

        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
