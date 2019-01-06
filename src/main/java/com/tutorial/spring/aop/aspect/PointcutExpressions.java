package com.tutorial.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutExpressions {

    // @Before("execution(public void addAccount())")
    // @Before("execution(* add*(com.tutorial.spring.aop.Account))")
    // @Before("execution(* add*(com.tutorial.spring.aop.Account, ..))")
    // @Before("execution(* add*(..))")

    //pointcut for package
    @Pointcut("execution(* com.tutorial.spring.aop.dao.*.*(..))") //any return type, package, any class, any method, 0 to many params
    public void forDaoPackage() {}

    //pointcut for getters
    @Pointcut("execution(* com.tutorial.spring.aop.dao.*.get*(..))")
    public void getters() {}
    //pointcut for setters

    @Pointcut("execution(* com.tutorial.spring.aop.dao.*.set*(..))")
    public void setters() {}

    //combining pointcuts .. exclude getters/setters from package
    @Pointcut("forDaoPackage() && !(getters() || setters())")
    public void forDaoPackageNoGettersOrSetters() {}

}
