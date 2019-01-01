package com.tutorial.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("[TennisCoach] inside no-arg constructor");
    }

/*
    @Autowired
    public void doSomeCrazyStuff(FortuneService fortuneService) {
        System.out.println("inside doSomeCrazyStuff");
        this.fortuneService = fortuneService;
    }
*/

    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("[TennisCoach] doMyStartupStuff");
    }

    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("[TennisCoach] doMyCleanupStuff");
    }

    @Autowired
    public TennisCoach(@Qualifier("fileRandomFortuneService")FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "[TennisCoach] Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
