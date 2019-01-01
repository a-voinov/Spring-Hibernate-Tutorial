package com.tutorial.spring.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FootballCoachApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FootballConfig.class);
        Coach coach = context.getBean("maradona", Coach.class);
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getDailyWorkout());
        context.close();
    }
}
