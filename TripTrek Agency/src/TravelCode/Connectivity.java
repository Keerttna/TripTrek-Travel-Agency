import java.sql.*;

public class Connectivity {
    Connection c;
    Statement s;

    public Connectivity() throws SQLException {
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/TripTrekDB", "root", "srk_1513");

            s = c.createStatement();

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
