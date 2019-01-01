package com.tutorial.spring.iocdi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String args[]){
        //load spring config file
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        //retrieve bean from the spring container
        Coach coach = context.getBean("myCoach", Coach.class);
        //call methods on the bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        //close context
        context.close();
    }
}
