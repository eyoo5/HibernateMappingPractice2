package controller;

import models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.DBUtility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class App {
    public static void main(String[] args) {
        manyToOne();
        oneToMany();
        oneToOne();
        manyToMany();
    }

    public static void manyToOne(){
        //Using my DB utilities to create session here:
        Session session = DBUtility.getConnection();
        Transaction transaction = session.beginTransaction();

        //creating Hospital
        Hospital hosp1 = new Hospital("Mount Sinai","123 Mulberry Street");
        Hospital hosp2 = new Hospital("Arkham Asylum","Batman Avenue");

        //creating Doctor
        Doctor d1 = new Doctor("Madmen", hosp1);
        Doctor d2 = new Doctor("Leslie", hosp2);
        Doctor d3 = new Doctor("Dr. Hurt", hosp1);

        //Storing Departments in database
        session.persist(hosp1);
        session.persist(hosp2);
        //Storing teachers  in database
        session.persist(d1);
        session.persist(d2);
        session.persist(d3);

        transaction.commit();
    }


    public static void oneToMany(){
        //Using my DB utilities to create session here:
        Session session = DBUtility.getConnection();
        Transaction transaction = session.beginTransaction();

        //creating teacher
        Doctor d1 = new Doctor("Kazi");
        Doctor d2 = new Doctor ("Esther");

        //Add doctor entity object to the list
        ArrayList<Doctor> doctorsList = new ArrayList<>();
        doctorsList.add(d1);
        doctorsList.add(d2);

        session.persist(d1);
        session.persist(d2);

        //Creating Department
        Specialty s1 = new Specialty("Cardiac");
        //Storing Department
        session.persist(s1);
        transaction.commit();
    }

    public static void oneToOne(){
        System.out.println("Maven + Hibernate + SQL One to One Mapping Annotations");

        //Using my DB utilities to create session here:
        Session session = DBUtility.getConnection();
        Transaction transaction = session.beginTransaction();


        //Lab way of making factory session:
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        Session session = factory.openSession();


        DoctorSchedule a1 = new DoctorSchedule("check up", "5-5-24");
        DoctorSchedule a2 = new DoctorSchedule("heart","12-25-24");

        Doctor d1 = new Doctor("Tim Burton");
        Doctor d2 = new Doctor("Sally Mae");
        a1.setDoctor(d1);
        a2.setDoctor(d2);




        session.persist(a1);
        session.persist(a2);
        session.persist(d1);
        session.persist(d2);

        transaction.commit();
    }

    public static void manyToMany(){
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        Session session = factory.openSession();
//        Transaction t = session.beginTransaction();

        //Using my DB utilities to create session here:
        Session session = DBUtility.getConnection();
        Transaction transaction = session.beginTransaction();

        //----- Create Hospital ------//
        Hospital h1 = new Hospital("Elmhurst Hospital","Broadway");
        session.persist(h1);

        //----Create Cohort/class Entity set one----
        Doctor d1 = new Doctor("John Doe", h1);
        Doctor d2= new Doctor("Jane Doe", h1);

        //------  Store Cohort  / Class  --------
        session.persist(d1);
        session.persist(d2);

        //-----Create Cohort one / Class one --------
        Set<Doctor> DoctorSet1 = new HashSet<Doctor>();
       DoctorSet1.add(d1);
        DoctorSet1.add(d2);

        //-----Create Cohort two / Class two --------
        Set<Doctor> DoctorSet2 = new HashSet<Doctor>();
        DoctorSet2.add(d1);
        DoctorSet2.add(d2);

        //-----Create Cohort Three / Class Three --------
        Set<Doctor> DoctorSet3 = new HashSet<Doctor>();
        DoctorSet3.add(d1);
        DoctorSet3.add(d2);

        Patient p1 = new Patient("Harry Styles", "123 Sesame Street", DoctorSet3);
        Patient p2 = new Patient("Taylor Swift", "123 Sesame Street", DoctorSet2);


        session.persist(p1);
        session.persist(p2);
        transaction.commit();
    }

}
