package com.jspiders.project.bms.main;

import com.jspiders.Users;
import com.jspiders.project.bms.Movie;
import com.jspiders.project.bms.MovieStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class HQLDemo2 {
    public static void main(String[] args) {
        //load configuration
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        //build session factory
        SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("sessionFactory created..");

        //get session from session factory
        Session session = sessionFactory.openSession();//connect to db
        System.out.println("session created..");

        Scanner scanner=new Scanner(System.in);

        //logics FROM Entity ref WHERE ref.dataMember = value;
        String selectUsersByMovie_HQL = "FROM movie mov WHERE mov.status='AVAILABLE'";

        Query<Movie> query = session.createQuery(selectUsersByMovie_HQL, Movie.class);
        List<Movie> resultList=query.getResultList();
        System.out.println(resultList);

        for(Movie mov:resultList){
            System.out.println(mov);
        }

//        System.out.println("Enter movie status to Search");
//        String status = scanner.next();
//        query2.setParameter("status", MovieStatus.valueOf(status));


        //close session
        session.close();
        System.out.println("session closed..");
        //close session factory
        sessionFactory.close();
        System.out.println("sessionFactory closed..");

        System.out.println("Program ends...");
    }
}
