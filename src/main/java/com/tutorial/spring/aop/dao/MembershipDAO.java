package com.tutorial.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addAccount(){
        System.out.println(getClass() + ": DOING MY DB WORK : ADDING A MEMBERSHIP ACCOUNT");
    }

    public void anyMeyhod(){
        System.out.println(getClass() + ": do anything");
    }
}
