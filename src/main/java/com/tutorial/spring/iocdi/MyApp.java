package com.tutorial.spring.iocdi;

public class MyApp {
    public static void main(String args[]){
        //create obj
        Coach baseballCoach = new TrackCoach(new HappyFortuneService());
        //use obj
        String res = baseballCoach.getDailyWorkout();
        //sout
        System.out.println(res);
    }
}
