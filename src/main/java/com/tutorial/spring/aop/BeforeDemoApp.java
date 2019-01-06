package com.tutorial.spring.aop;

import com.tutorial.spring.aop.dao.AccountDAO;
import com.tutorial.spring.aop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeforeDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class); //cglib proxy
        Account account = new Account();
        account.setLevel("VIP");
        account.setName("Goldman");
        accountDAO.addAccount(account, true);
        //testing getters/setters
        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");
        String name = accountDAO.getName();
        String serviceCode = accountDAO.getServiceCode();
        System.out.println();

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class); //cglib proxy
        membershipDAO.addAccount();
        membershipDAO.anyMeyhod();
        context.close();
    }
}
