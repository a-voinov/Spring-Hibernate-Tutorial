package com.tutorial.spring.annotations;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private String[] fortunes = {
            "Today's weirdness is tomorrow's reason why.",
            "You're a card which will have to be dealt with.",
            "This will be a memorable month -- no matter how hard you try to forget it."
    };

    @Override
    public String getFortune()  {
        Random random = new Random();
        return fortunes[random.nextInt(3)];
    }
}
