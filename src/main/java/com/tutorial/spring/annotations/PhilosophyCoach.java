package com.tutorial.spring.annotations;

import org.springframework.beans.factory.annotation.Value;

public class PhilosophyCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    public PhilosophyCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkout() {
        return "[PhilosophyCoach] read some Plato dialogue";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
