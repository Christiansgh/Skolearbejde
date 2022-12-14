import java.sql.*;
import java.util.ArrayList;

public class Main {
  private static Connection connection;

  public static void main(String[] args) {
    loadJdbcDriver();
    openConnection("SkoleDB");

    ArrayList<Student> students = getStudentsBySemesterNo(3);
    ArrayList<Teacher> teachers = getTeachersWhere("");

    for (Student student : students) {
      System.out.println(student);
    }

  }
  
  private static boolean loadJdbcDriver() {
    try {
      System.out.println("Loading JDBC driver...");
      
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      
      System.out.println("JDBC driver loaded");
      
      return true;
    }
    catch (ClassNotFoundException e) {
      System.out.println("Could not load JDBC driver!");
      return false;
    }
  }
  
  private static boolean openConnection(String databaseName) {
    String connectionString =
        "jdbc:sqlserver://localhost:1433;" +
        "instanceName=SQLEXPRESS;" +
        "databaseName=" + databaseName + ";" +
        "integratedSecurity=true;";

    connection = null;
    
    try {
      System.out.println("Connecting to database...");
      
      connection = DriverManager.getConnection(connectionString);
      
      System.out.println("Connected to database");
      
      return true;
    }
    catch (SQLException e) {
      System.out.println("Could not connect to database!");
      System.out.println(e.getMessage());
      
      return false;
    }
  }
  
  private static ArrayList<Student> getStudentsBySemesterNo(int semesterNo) {
    return getStudentsWhere("semester_no = " + semesterNo);
  }
  
  private static ArrayList<Student> getStudentsWhere(String whereClause) {
    try {
      ArrayList<Student> students = new ArrayList<Student>();
      
      String sql = "SELECT * FROM student WHERE " + whereClause;
      
      Statement statement = connection.createStatement();

      ResultSet resultSet = statement.executeQuery(sql);

      // iteration starter 'before first'
      while (resultSet.next()) {
        // hent data fra denne række
        int id = resultSet.getInt("id");
        String lastName = resultSet.getString("lastname");
        String firstName = resultSet.getString("firstname");
        int semesterNo = resultSet.getInt("semester_no");
        
        students.add(new Student(id, lastName, firstName, semesterNo));
      }
      
      return students;
    }
    catch (SQLException e) {
      System.out.println("Error: could not get all students.");
      System.out.println(e.getMessage());
      
      return null;
    }
  }


  private static ArrayList<Teacher> getTeachersWhere(String whereClause) {
    try {
      ArrayList<Teacher> teachers = new ArrayList<Teacher>();
      
      String sql = "SELECT * FROM teacher WHERE " + whereClause;
      
      Statement statement = connection.createStatement();

      ResultSet resultSet = statement.executeQuery(sql);

      // iteration starter 'before first'
      while (resultSet.next()) {
        // hent data fra denne række
        int id = resultSet.getInt("id");
        String initials = resultSet.getString("navn");
        
        teachers.add(new Teacher(id, initials));
      }
      
      return teachers;
    }
    catch (SQLException e) {
      System.out.println("Error: could not get all students.");
      System.out.println(e.getMessage());
      
      return null;
    }
  }
}


