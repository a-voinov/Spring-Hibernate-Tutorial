package com.tutorial.spring.aop.service;

import com.tutorial.spring.annotations.FortuneService;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return "Expect heavy traffic this morning";
    }

    public String getFortune(boolean tripWire) {
        if (tripWire)
            throw new RuntimeException("Highway is closed");

        return getFortune();
    }
}
