package com.jspiders;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TableCreationDemo {
    public static void main(String[] args){
        System.out.println("Program starts");


        System.out.println("Open Session");

        //load configuration
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        System.out.println(" Closed Session");

        //build session factory
        SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("Session Factory created");
        System.out.println("Closed Session");
        //connect to db
        Session session = sessionFactory.openSession();
        System.out.println("Session created");
        System.out.println(" Closed SessionFactory");


        //logics

        //close session
        session.close();
        System.out.println("Session closed");
        sessionFactory.close();
        System.out.println(" SessionFactory Closed");


        System.out.println("Program ends");
    }
}
