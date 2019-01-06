package com.tutorial.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyAPIAnalyticsAspect    {

    @Before("com.tutorial.spring.aop.aspect.PointcutExpressions.forDaoPackageNoGettersOrSetters()")
    public void performAPIAnalytics(){
        System.out.println("\n<AOP>-----------> Performing API Analytics");
    }

}
