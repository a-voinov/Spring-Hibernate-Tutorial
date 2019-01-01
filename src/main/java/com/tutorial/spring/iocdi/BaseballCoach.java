package com.tutorial.spring.iocdi;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "[BaseballCoach] baseball practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
