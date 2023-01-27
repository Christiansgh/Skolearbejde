package src.DataAccesLayer;
import java.sql.*;

public class DAL {
  private Connection connection; 
  private Statement statement;
  private PreparedStatement preparedStatement;
  private ResultSet resultSet;
  private ResultSetMetaData resultSetMetaData;

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
        return -1; //meaning no result found
      } 
    }
    catch (SQLException e) {
      System.out.println(e);
      return -1;
    }
  }

  //Exectute a query and return the result as a resultset.
  public ResultSet read(String query) {
    try {
      statement = connection.createStatement(); 
      resultSet = statement.executeQuery(query);
      return resultSet;
    }
    catch(SQLException e) {
      System.out.println(e);
      return resultSet;
    }
  }

  //queries the the table for amount of columns. returns as int. Used to determine the amount of input boxes to show
  public int getColumnAmount(String tableName) {
    try {
      System.out.printf("Getting number of columns in table %s \n", tableName);
      statement = connection.createStatement(); //instantiate the statement
      resultSet = statement.executeQuery(String.format("SELECT * FROM %s", tableName)); //execute the query
      resultSetMetaData = resultSet.getMetaData(); //get the meta data
      System.out.printf("Found %d columns \n", resultSetMetaData.getColumnCount());
      return resultSetMetaData.getColumnCount(); //return the column count.
    }
    catch (SQLException e){
      System.out.println(e);
      return -1; //on exception return -1
    }
  }

  //INSERT INTO prepared statement. Methods below are overloaded to accomidate for different amount of columns pr. table.
  //   - NB. factoring in "IDENTITY", the maximum amount of columns our table has is 4. If this number gets increased, we need to further overload than 4.
  //NOT DRY Code. Space for implementing servicemethods to reduce redundancy, but not enough time.
  public void insertInto(String tableName, String column1, String value1) {
    try {
      preparedStatement = connection.prepareStatement(String.format("INSERT INTO %s (%s) VALUES (?)", tableName, column1));
      preparedStatement.setString(1, value1); 
      int rowsAffected = preparedStatement.executeUpdate(); //execute the query
      printRowsAffected(rowsAffected); //prints rows affected. 1 is a successful INSERT.
    }  
    catch(SQLException e) {
      System.out.println(e);
    }
  }

  //2 values
  public void insertInto(String tableName, String column1, String column2, String value1, String value2) {
    try {
      preparedStatement = connection.prepareStatement(String.format("INSERT INTO %s (%s, %s) VALUES (?, ?)", tableName, column1, column2));
      preparedStatement.setString(1, value1); 
      preparedStatement.setString(2, value2);
      int rowsAffected = preparedStatement.executeUpdate();
      printRowsAffected(rowsAffected); //prints rows affected. 1 is a successful INSERT.
    }  
    catch(SQLException e) {
      System.out.println(e);
    }
  }

  //3 values
  public void insertInto(String tableName, String column1, String column2, String column3, String value1, String value2, String value3) {
    try {
      preparedStatement = connection.prepareStatement(String.format("INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)", tableName, column1, column2, column3));
      preparedStatement.setString(1, value1); 
      preparedStatement.setString(2, value2);
      preparedStatement.setString(3, value3);
      int rowsAffected = preparedStatement.executeUpdate();
      printRowsAffected(rowsAffected); //prints rows affected. 1 is a successful INSERT.
    }  
    catch(SQLException e) {
      System.out.println(e);
    }
  }

  //4 values
  public void insertInto(String tableName, String column1, String column2, String column3, String column4, String value1, String value2, String value3, String value4) {
    try {
      preparedStatement = connection.prepareStatement(String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (?, ?, ?, ?)", tableName, column1, column2, column3, column4));
      preparedStatement.setString(1, value1); 
      preparedStatement.setString(2, value2);
      preparedStatement.setString(3, value3);
      preparedStatement.setString(4, value4);
      int rowsAffected = preparedStatement.executeUpdate();
      printRowsAffected(rowsAffected); //prints rows affected. 1 is a successful INSERT.
    } 
    catch(SQLException e) {
      System.out.println(e);
    }
  }

  //Service method printing the amount of rows affected by the query.
  private void printRowsAffected(int rowsAffected) {
    if(rowsAffected == 1) {
      System.out.println("Successfully inserted 1 row."); //this should get something visual implemented.
    }
    else if(rowsAffected > 1) {
      System.out.println("Something went wrong! You affected more than one rows!"); // -II-
    }
    else {
      System.out.println("Something went wrong! No rows were affected."); // -II-
    }
  }
}