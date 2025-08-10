// import java.sql.Connection;
// import java.sql.DriverManager;

// public class Main {
//     public static void main(String[] args) throws Exception
//     {
//         Class.forName("com.mysql.cj.jdbc.Driver");
//         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","@Adi2005#");

//         if(conn != null) {
//             System.out.println("Connection established Successfully!");
//         } else {
//             System.out.println("Failed to establish connection.");
//         }
//         if (conn != null) {
//             conn.close();
//         }
//     }
// }

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/employee";
    private static final String USER = "root";
    private static final String PASS = "@Root!";
    public static void main(String[] args){
      
        String insertSql = "INSERT INTO employee(name, salary, dept) VALUES(?,?,?)";
        String selectSql = "SELECT id, name, salary, dept FROM employee";
        
        try(
            
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
        ) {
            System.out.println("-----Executing INSERT Operation");
            insertStmt.setString(1, "John Doe");
            insertStmt.setDouble(2, 50000.00);
            insertStmt.setString(3, "CS");
            int rowsAffected = insertStmt.executeUpdate();
            System.out.println(rowsAffected + "row(s) inserted successfully!");

            insertStmt.setString(1, "James Width");
            insertStmt.setDouble(2, 65000.00);
            insertStmt.setString(3, "CS");
            rowsAffected = insertStmt.executeUpdate();
            System.out.println(rowsAffected + "row(s) inserted successfully!");   
            
            insertStmt.setString(1, "Rohit Sharma");
            insertStmt.setDouble(2, 70000.00);
            insertStmt.setString(3, "CSBS");
            rowsAffected = insertStmt.executeUpdate();
            System.out.println(rowsAffected + "row(s) inserted successfully!");
            
            System.out.println("\n----Executing SELECT Operation----"); 

            try(
                PreparedStatement selectStmt =conn.prepareStatement(selectSql);
                ResultSet rs = selectStmt.executeQuery();
            ){
                System.out.println("Employee Data:");
                System.out.println("-------------------------");
                
                while(rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double salary = rs.getDouble("salary");
                    String dept = rs.getString("dept");

                    System.out.printf("ID: %d, NAME: %s, SALARY: $%.2f, DEPT: %s%n", id, name, salary, dept); 
                    System.out.println();
                }
            }
        } catch(SQLException e){
            System.err.println("SQL Exception Occurred: " + e.getMessage());
        }
    } 
}




