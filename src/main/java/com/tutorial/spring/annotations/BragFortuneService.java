package com.tutorial.spring.annotations;

public class BragFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Don't get to bragging.";
    }
}
