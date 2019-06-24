package com.hateyahighschool.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by A.A.MAMUN on 6/24/2019.
 */
public class DbConnection {

    private boolean bol = false;
    private String ex = "exception : ";
    private Statement statement;
    private Connection connection;

    public DbConnection()
    {

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://ec2-184-73-169-163.compute-1.amazonaws.com:5432/d1g8ev73faonak","flvwuvhskzzpnc","9d166ebcb3ea181cd4ba149829a57a5804c6724214af7b3b8eb75f2600ccacc7");
            statement = connection.createStatement();
            System.out.println("Success !");
            bol = true;
        } catch (Exception e) {
            bol = false;
            ex+= ex.toString();
            e.printStackTrace();
        }


    }


    public String getEx(){
        return ex;
    }

    public boolean getBol() {
        return bol;
    }



    /*
    public static void main(String[] args)
    {
        DbConnection dbc = new DbConnection();
        System.out.println(dbc.bol);

    }
    */




}
