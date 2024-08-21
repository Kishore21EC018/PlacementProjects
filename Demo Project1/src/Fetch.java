import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch {
 public static void main(String[] args) {
  String URL = "jdbc:mysql://localhost:3306/std1";
  String USER = "root";
  String PASSWORD = "Kishore0806";

  try {
   Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

      // Read Operation
      String selectSQL = "SELECT * FROM CompliantRegister";
      Statement selectStatement = con.createStatement();
      ResultSet resultSet = selectStatement.executeQuery(selectSQL);
   
      System.out.println("Read operation results:");
      while (resultSet.next()) {
       // Corrected column names to match your table schema
       System.out.println("Person ID: " + resultSet.getInt("Person_Id") 
        + ", Person Name: " + resultSet.getString("Person_Name") 
        + ", Compliant Name: " + resultSet.getString("Compliant_Name") 
        + ", Person Email: " + resultSet.getString("Person_Email") 
        + ", Complianting Date: " + resultSet.getDate("Complianting_date"));
      }
     } catch (SQLException e) {
  System.out.println(e);
   }
}
}