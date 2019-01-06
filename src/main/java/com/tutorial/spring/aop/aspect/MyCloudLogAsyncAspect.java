package com.tutorial.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("com.tutorial.spring.aop.aspect.PointcutExpressions.forDaoPackageNoGettersOrSetters()")
    public void logToCloud(){
        System.out.println("\n<AOP>-----------> Logging to Cloud in async fashion");
    }

}
