package com.jspiders.project.bms.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OnetoManyDemo {

    private static SessionFactory sessionFactory = null;

    static {
        //load configuration
        System.out.println("1.Load Configuration");
        Configuration config = new Configuration();
        config.configure("hibernate.bms.cfg.xml");

        //create sessionfactory
        System.out.println("2.Create SessionFactory");
        sessionFactory = config.buildSessionFactory();
    }


    public static void main(String[] args) {
        System.out.println("Program Starts....");


        Session session = sessionFactory.openSession();

        sessionFactory.close();
        System.out.println("SessionFactory closed....");

        System.out.println("Program Ends....");



    }
}
