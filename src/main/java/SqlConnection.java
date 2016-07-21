import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by employee on 7/21/16.
 */

public interface SqlConnection {

    public Connection getConnection() throws Exception;

}
