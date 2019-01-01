package com.tutorial.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext-Annotations.xml");
        Coach coach = context.getBean("tennisCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        context.close();
    }
}
