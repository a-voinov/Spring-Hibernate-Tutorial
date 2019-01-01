package com.tutorial.spring.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FootballConfig {

    @Bean
    public FortuneService bragFortune(){
        return new BragFortuneService();
    }

    @Bean
    public Coach maradona(){
        return new FootballCoach(bragFortune());
    }

}
