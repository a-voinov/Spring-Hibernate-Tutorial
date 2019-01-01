package com.tutorial.hibernate.homework;

import com.tutorial.hibernate.homework.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            System.out.println("creating database entities....");
            Employee employee1 = new Employee("John", "Doe", "Google");
            Employee employee2 = new Employee("Jane", "Doe", "Amazon");
            Employee employee3 = new Employee("Jim", "Halpert", "Dunder Mifflin");
            Employee employee4 = new Employee("Dwight", "Shrute", "Dunder Mifflin");
            create(sessionFactory, employee1);
            create(sessionFactory, employee2);
            create(sessionFactory, employee3);
            create(sessionFactory, employee4);
            System.out.println("reading entities with ids 1,3,4....");
            System.out.println(read(sessionFactory, 1));
            System.out.println(read(sessionFactory, 3));
            System.out.println(read(sessionFactory, 4));
            System.out.println("retrieving all Dunder Mifflin employees...");
            List<Employee> employees = readByCompany(sessionFactory, "Dunder Mifflin");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
            System.out.println("deleting first two employees...");
            System.out.println(delete(sessionFactory, 1));
            System.out.println(delete(sessionFactory, 2));
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }

    private static int create(SessionFactory sessionFactory, Employee employee){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        return employee.getId();
    }

    private static Employee read(SessionFactory sessionFactory, int pk){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, pk);
        session.getTransaction().commit();
        return employee;
    }

    private static List<Employee> readByCompany(SessionFactory sessionFactory, String company){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Employee> employees = session.createQuery(
                String.format("from Employee e where e.company = '%s'", company),
                Employee.class).getResultList();
        session.getTransaction().commit();
        return employees;
    }

    private static int delete(SessionFactory sessionFactory, int pk){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, pk);
        session.delete(employee);
        session.getTransaction().commit();
        return employee.getId();
    }
}
