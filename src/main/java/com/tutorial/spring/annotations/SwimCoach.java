package com.tutorial.spring.annotations;

import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "[SwimCoach] swim 30 lanes";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }

}
