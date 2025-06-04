import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseExample {
    public static void main(String[] args) {
        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/testdb";  // Replace 'testdb' with your DB name
        String user = "root";   // Your DB username
        String password = "password"; // Your DB password

        try {
            // 1. Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database successfully!");

            // 2. Create a statement object to execute queries
            Statement stmt = conn.createStatement();

            // 3. Execute a query (for example, select data from table 'users')
            String sql = "SELECT id, name, email FROM users";
            ResultSet rs = stmt.executeQuery(sql);

            // 4. Process the ResultSet
            while (rs.next()) {
                int id = rs.getInt("id");             // get integer column
                String name = rs.getString("name");  // get string column
                String email = rs.getString("email");

                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

            // 5. Close connections
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error connecting to database:");
            e.printStackTrace();
        }
    }
}
