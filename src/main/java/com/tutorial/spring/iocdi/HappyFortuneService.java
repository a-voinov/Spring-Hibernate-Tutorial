package com.tutorial.spring.iocdi;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }
}
