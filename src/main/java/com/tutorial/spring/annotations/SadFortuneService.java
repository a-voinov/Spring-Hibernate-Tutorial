package com.tutorial.spring.annotations;

public class SadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "This will be a memorable month -- no matter how hard you try to forget it.";
    }
}
