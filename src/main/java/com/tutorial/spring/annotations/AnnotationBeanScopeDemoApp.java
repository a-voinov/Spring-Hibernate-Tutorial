package com.tutorial.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext-Annotations.xml");
        Coach coach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
        System.out.println(coach);
        System.out.println(alphaCoach);
        context.close();
    }
}
