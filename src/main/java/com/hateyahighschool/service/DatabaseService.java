package com.hateyahighschool.service;


import java.sql.*;

public class DatabaseService {

  private Statement statement;
  private Connection connection;

  public DatabaseService()
  {
      try {
          Class.forName("com.mysql.jdbc.Driver");
          connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mitu","root","");
          statement = connection.createStatement();
          //connection.close();
          System.out.print("Success !");
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


  public void getData()
  {
      try {
         ResultSet rs = statement.executeQuery("SELECT * FROM USER ");
         while(rs.next()){
            System.out.println( rs.getString(1));
         }
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }


   public static void main(String[] args) throws SQLException {
        DatabaseService dbc = new DatabaseService();
        dbc.getData();
        //dbc.connection.close();


   }


}
