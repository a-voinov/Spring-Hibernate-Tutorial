package com.tutorial.spring.iocdi;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "[TrackCoach] run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    //init bean method
    public void init(){
        System.out.println("[TrackCoach] init method");
    }
    //destroy bean method
    public void cleanup(){
        System.out.println("[TrackCoach] destroy method");
    }
}
