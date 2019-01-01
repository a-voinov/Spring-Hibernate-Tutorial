package com.tutorial.spring.iocdi;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "[SwimCoach] swim 30 lanes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
