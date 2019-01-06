package com.tutorial.spring.aop;

import com.tutorial.spring.annotations.FortuneService;
import com.tutorial.spring.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

    private static Logger myLogger =
            Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        FortuneService fortuneService = context.getBean("trafficFortuneService", FortuneService.class);
        myLogger.info("\n\nMain program: AroundDemoApp");
        myLogger.info("Calling Get Fortune");
        boolean tripWire = true;
        myLogger.info("\nMy fortune is : " + ((TrafficFortuneService)fortuneService).getFortune(tripWire));
        myLogger.info("Finished");
        context.close();
    }
}
