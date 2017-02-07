import java.sql.*;

public class Lab2_1_1
{
  public static void main( String args[] )
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:student.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "INSERT INTO STUDENT (SAP_ID,NAME,AGE,ADDRESS,CLASS) " +
                   "VALUES (500041199, 'Deepanshu', 18, 'INDIA', 12 );"; 
      stmt.executeUpdate(sql);
             sql = "INSERT INTO STUDENT (SAP_ID,NAME,AGE,ADDRESS,CLASS) " +
                   "VALUES (500037844, 'Shubhankar', 19, 'INDIA', 12 );"; 
      stmt.executeUpdate(sql);
      
      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table created successfully");
  }
}