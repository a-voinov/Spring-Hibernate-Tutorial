package com.tutorial.spring.iocdi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String args[]){
        //load spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
        //retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);
        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        System.out.println(theCoach);
        System.out.println(alphaCoach);

        context.close();
    }
}
