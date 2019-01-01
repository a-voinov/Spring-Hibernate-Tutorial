package com.tutorial.spring.iocdi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String args[]){
        //load the spring config
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //retrieve bean from spring container
        CricketCoach coach = context.getBean("myCricketCoach", CricketCoach.class);
        //call methods for a bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getEmail());
        System.out.println(coach.getTeam());
        //close the context
        context.close();
    }
}
