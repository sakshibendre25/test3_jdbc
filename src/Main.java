
// program for update data into db


import java.sql.*;
public class Main {
    public static void main(String[] args)throws ClassNotFoundException  {

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "root";
        String query = "UPDATE employees\n" +
                "SET job_title = 'Full Stack Devloper',salary=50000.0\n" +
                        "WHERE id = 1;";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded succesfully");
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());

        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("connection established succesfully");
            Statement stmt = con.createStatement();
            int rowsaffected = stmt.executeUpdate(query);

            if(rowsaffected>0) {
                System.out.println("Updation Succesfull." + rowsaffected + " row(s) affected.");
            }else {
                System.out.println("Updation Failed");


            }
            stmt.close();
            con.close();

            System.out.println("connection closed succesfully");

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}