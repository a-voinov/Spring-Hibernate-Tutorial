package com.tutorial.spring.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext(MyLoggerConfig.class, SportConfig.class);
        PhilosophyCoach coach = context.getBean("philosophyCoach", PhilosophyCoach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println("email: " + coach.getEmail());
        System.out.println("team: " + coach.getTeam());
        context.close();
    }
}
