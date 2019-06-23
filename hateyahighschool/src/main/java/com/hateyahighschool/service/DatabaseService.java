package com.hateyahighschool.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseService {

  private Statement statement;
  private Connection connection;

  public DatabaseService()
  {
      try {
          Class.forName("com.mysql.jdbc.Driver");
          connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mitu","root","");
          statement = connection.createStatement();
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

  public Statement getStatement() {
        return statement;
    }

    public void insertData(long id, String email, String pass){

        try{
            statement.execute("INSERT into user values("+id+",'"+email+"','"+pass+"')");
        }catch (Exception ex){
            System.out.println("Ex : "+ex);
        }

    }

}
