package com.tutorial.spring.aop;

import com.tutorial.spring.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = null;
        try{
            boolean tripWire = false;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception ex){
            System.out.println("\n\nMain program: caught exception : " + ex);
        }
        System.out.println("\n\nMain program: AfterThrowingDemoApp");
        System.out.println("------");
        System.out.println(accounts);
        context.close();
    }
}
