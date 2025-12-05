package com.jspiders.project.bms.main;

import com.jspiders.project.bms.Address;
import com.jspiders.project.bms.Audi;
import com.jspiders.project.bms.movie_metadata;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class OnetoOneDemo2 {

    // movie--> movie_metadata = id,genere,format,rating,releaseDate
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

//    public static void savemovie_metadata() {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        System.out.println("Creating Movie_metadata....");
//        movie_metadata mm = new movie_metadata();
//        mm.setId(1L);
//        mm.setGenere("Horror");
//        mm.setFormat("3D");
//        mm.setRating(4);
//        mm.setReleaseDate(LocalDate.ofEpochDay(30 - 12 - 2025));
//
//     Object a1 = null;
//        a1.setmovie_metadata(mm);
//    }

    public static void getAudiDetails(Long id) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Audi a1=session.find(Audi.class,id);
        System.out.println();
        System.out.println("****************Audi Details***************");
        System.out.println("ID           :  " +a1.getId());
        System.out.println("Name         :  " +a1.getName());
        System.out.println("Seat Rows    :  " +a1.getSeatRows());
        System.out.println("Seat Columns :  " +a1.getSeatColumns());

        System.out.println("Street       :  " +a1.getAddress().getStreet());
        System.out.println("Area         :  " +a1.getAddress().getArea());
        System.out.println("City         :  " +a1.getAddress().getCity());
        System.out.println("****************Audi Details***************");
        System.out.println();

        transaction.commit();
        session.close();


    }

    public static void getAudiAddress(Long id)
    {
        Session session = sessionFactory.openSession();

        System.out.println("Finding audi address....");

        //begin transaction
        Transaction transaction = session.beginTransaction();

        //find audi address
        Address ad1 = session.find(Address.class,id);//Select * from audi_address where id = ?

        System.out.println();
        System.out.println("============Audi Address Details===========");
        System.out.println("ID      : "+ad1.getId());
        System.out.println("Street  : "+ad1.getStreet());
        System.out.println("City    : "+ad1.getCity());
        System.out.println("Area    : "+ad1.getArea());
        //System.out.println("Pincode : "+ad1.getPinCode());

        System.out.println("============Audi Address Details===========");

        System.out.println("============Audi Details===========");
        System.out.println("Name : "+ad1.getAudi().getName());
        System.out.println("Rows : "+ad1.getAudi().getSeatRows());
        System.out.println("Columns : "+ad1.getAudi().getSeatColumns());
        System.out.println("============Audi Details===========");
        System.out.println();

        session.close();
    }
    public static void main(String[] args) {
        System.out.println("Program Starts....");

        // saveAudi();
        // deleteAudi(1l);

       // getAudiDetails(2L);
       // savemovie_metadata();

      //  getAudiDetails(2l);
        getAudiAddress(2l);
        sessionFactory.close();
        System.out.println("SessionFactory closed....");

        System.out.println("Program Ends....");


    }
}