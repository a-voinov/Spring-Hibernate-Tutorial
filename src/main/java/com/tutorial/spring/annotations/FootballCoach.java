package com.tutorial.spring.annotations;

public class FootballCoach implements Coach {

    private FortuneService fortuneService;

    public FootballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "[FootballCoach] strike a goal 5 times";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
