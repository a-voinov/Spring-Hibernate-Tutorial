package com.tutorial.spring.aop.aspect;

import com.tutorial.spring.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.tutorial.spring.aop.aspect.PointcutExpressions.forDaoPackageNoGettersOrSetters()")
    public void beforeAddAccountServiceAdvice(JoinPoint joinPoint){
        System.out.println("\n<AOP>-----------> Executing @Before advice on method");
        //retrieving method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Meghod signature : " + methodSignature);
        //retrieving method arguments values
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(">>" + arg);
            if (arg instanceof Account){ //printing account specific data
                System.out.println("account name : " + ((Account)arg).getName());
                System.out.println("account level : " + ((Account)arg).getLevel());
            }
        }
    }

    @Pointcut("execution(* com.tutorial.spring.aop.dao.AccountDAO.findAccounts(..))")
    public void findAccounts(){}

    @AfterReturning(
            pointcut = "findAccounts()",
            returning = "result")
    public void afterReturningFindAccountsAdvice(
            JoinPoint joinPoint,
            List<Account> result
    ){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n<AOP>-----------> Executing @AfterReturning advice on method " + method);
        System.out.println("<AOP>-----------> result is " + result);
        //intercepting and modifying the data
        convertAccountNamesToUppercase(result);
        System.out.println("<AOP>-----------> MODIFIED result is " + result);
    }

    private void convertAccountNamesToUppercase(List<Account> result) {
        for (Account account : result) {
            String uppercaseName = account.getName().toUpperCase();
            account.setName(uppercaseName);
        }
    }

    @AfterThrowing(pointcut = "findAccounts()",
                    throwing = "exc")
    public void afterThrowingFindAccountsAdvice(
            JoinPoint joinPoint,
            Throwable exc){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n<AOP>-----------> Executing @AfterThrowing advice on method " + method);
        //log the exception
        System.out.println("The exception is : " + exc);
    }

    @After("findAccounts()")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n<AOP>-----------> Executing @After (finally) advice on method " + method);
    }

    private Logger myLogger =
            Logger.getLogger(getClass().getName());

    @Around("execution(* com.tutorial.spring.aop.service.*.getFortune(..))")
    public Object getFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String method = proceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n<AOP>-----------> Executing @Around advice on method " + method);
        //get begin timestamp
        long begin = System.currentTimeMillis();
        Object result = null;
        try {
            //execute method
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            myLogger.warning(throwable.getMessage());
            result = "Major accident, but don't worries! Helicopter on the way!";
            //rethrowing the exception
            //throw throwable;
        }
        //get end timestamp
        long end = System.currentTimeMillis();
        long duration = end - begin;
        myLogger.info("\n<AOP>==================> DURATION : " + duration / 1000.0 + " seconds");
        return result;
    }

}
