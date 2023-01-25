package src.DataAccesLayer;
import java.sql.*;

public class DAL {
  private Connection connection; 
  private PreparedStatement preparedStatement;
  private ResultSet resultSet;

  //constructor, creates the connection.
  public DAL(String databaseName) {
    openConnection(databaseName);
  }

  //service method for the constructor to load the DB.
  private boolean openConnection(String databaseName) {
    String connectionString =
      "jdbc:sqlserver://localhost:1433;" +
      "instanceName=SQLEXPRESS;" +
      "databaseName=resono;" +
      "integratedSecurity=true;" +
      "trustservercertificate=true";
    try {
      System.out.println("Connecting to database...");
          
      connection = DriverManager.getConnection(connectionString);
          
      System.out.println("Connected to database");
          
      return true;
    }
    catch (SQLException e) {
      connection = null;
    
      System.out.println("Could not connect to database!");
      System.out.println(e.getMessage());
          
      return false;
    }
  }

  //queries the database for the parameters. Returns an int (0 / 1) on success, and -1 on fail.
  public int checkAuthentication(String username, String password) {
    try {
      preparedStatement = connection.prepareStatement("SELECT * FROM logins WHERE username=? and password=?");
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, password);

      resultSet = preparedStatement.executeQuery(); //pointer is before first row.
  
      if (resultSet.next()) { // rs.next moves forwards and returns true if theres a result.
        return resultSet.getInt("user_type"); // meaning result found
      } 
      else {
        return -1;
      } 
    }
    catch (SQLException e) {
      System.out.println(e);
      return -1;
    }
  }
}