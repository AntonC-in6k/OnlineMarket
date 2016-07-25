/**
 * Created by employee on 7/22/16.
 */

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;

import java.sql.Connection;


public class SqlConnectionForTestImpl {
    private static IDatabaseTester databaseTester;

    public Connection getConnection() throws Exception {
        databaseTester = new JdbcDatabaseTester(org.hsqldb.jdbcDriver.class
                .getName(), "jdbc:hsqldb:mem:aname");
        return databaseTester.getConnection().getConnection();
    }

}
