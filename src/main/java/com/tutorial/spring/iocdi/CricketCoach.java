package com.tutorial.spring.iocdi;

public class CricketCoach implements Coach {

    private FortuneService fortuneService;
    private String email;
    private String team;

    public CricketCoach() {
        System.out.println("[CricketCoach] inside no-arg constructor");
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("[CricketCoach] setFortuneService");
        this.fortuneService = fortuneService;
    }

    public void setEmail(String email) {
        System.out.println("[CricketCoach] setEmail");
        this.email = email;
    }

    public void setTeam(String team) {
        System.out.println("[CricketCoach] setTeam");
        this.team = team;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkout() {
        return "[CricketCoach] practice fast bowling";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
