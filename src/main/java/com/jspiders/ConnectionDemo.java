package com.jspiders;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionDemo {
    public static void main(String[] args) {
        System.out.println("Program starting now");

        //load configuration
        Configuration config=new Configuration();
        config.configure("hibernate.cfg.xml");

        //build session factory
        SessionFactory sessionFactory=config.buildSessionFactory();
        System.out.println("Session Factory created");

        //connect to db
        Session session=sessionFactory.openSession();
        System.out.println("Session created");


        //logics

        //close session
        session.close();
        sessionFactory.close();


        System.out.println("Program ends");

    }
}