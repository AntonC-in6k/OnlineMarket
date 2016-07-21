import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by employee on 7/21/16.
 */
public class SqlConnectionImpl implements SqlConnection {

    public Connection getConnection() throws SQLException {
       Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/market",
                "root","IwtFbhGh_71");
        return connection;
    }
}
