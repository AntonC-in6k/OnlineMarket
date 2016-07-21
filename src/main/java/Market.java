/**
 * Created by employee on 7/21/16.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Market {
    private static Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getSQLConnection() throws SQLException {
        connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/market",
                "root","IwtFbhGh_71");
        return connection;
    }


    public static String getCategory() throws SQLException {
        Statement stmt= connection.createStatement();
        ResultSet rs = stmt.executeQuery("select * from CATEGORY");
        String result = rs.toString();
        return result;
    }
}
