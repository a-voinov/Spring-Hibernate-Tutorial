package com.tutorial.spring.aop;

import com.tutorial.spring.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = null;
        try{
            boolean tripWire = true;
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
