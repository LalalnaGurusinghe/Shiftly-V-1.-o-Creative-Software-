import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/employee_management"; // Use the correct port {if u use it without changing by default it is 3306 }
        String username = "root";
        String psw = "12345#Lmg";
        String query = "SELECT e.employee_id, e.first_name, e.last_name, e.position, e.salary, d.department_name FROM employees e JOIN departments d ON e.department_id = d.department_id";

        // Load the MySQL JDBC driver {old version on thelusko this is the new version}
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection {this is an interface}
        Connection con = DriverManager.getConnection(url, username, psw);

        // Create a statement {this is an interface}
        Statement st = con.createStatement();

        // Execute the query
        ResultSet rs = st.executeQuery(query);

        // Process the result
        int i = 1;
        while(rs.next()){
            int emp_id = rs.getInt(1);
            String emp_first_name = rs.getString(2);
            String emp_last_name = rs.getString(3);
            String emp_position =  rs.getString(4);
            String department = rs.getString(6);
            double salary = rs.getDouble(5);

            if (emp_first_name.equals("Shashika") || emp_first_name.equals("Sumudu")) {
                System.out.println("Our " + i + " Employee of the sector is : " + "Mrs " + emp_first_name + " " + emp_last_name + ", She works as a " + emp_position + " in " + department + " department");
            }
            else {
                System.out.println("Our " + i + " Employee of the sector is : " + "Mr " + emp_first_name + " " + emp_last_name + ", He works as a " + emp_position + " in " + department + " department");
            }

            i++;


        }

        // Close resources
        rs.close();
        st.close();
        con.close();
    }
}