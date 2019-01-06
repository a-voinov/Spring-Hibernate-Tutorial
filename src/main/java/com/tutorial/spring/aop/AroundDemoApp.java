package com.tutorial.spring.aop;

import com.tutorial.spring.annotations.FortuneService;
import com.tutorial.spring.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class AroundDemoApp {

    private static Logger myLogger =
            Logger.getLogger(AroundDemoApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        FortuneService fortuneService = context.getBean("trafficFortuneService", FortuneService.class);
        myLogger.info("\n\nMain program: AroundDemoApp");
        myLogger.info("Calling Get Fortune");
        myLogger.info("\nMy fortune is : " + fortuneService.getFortune());
        myLogger.info("Finished");
        context.close();
    }
}
