package com.tutorial.spring.iocdi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {
    public static void main(String args[]){
        //load spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");
        //retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);
        System.out.println(theCoach);
        context.close();
    }
}
