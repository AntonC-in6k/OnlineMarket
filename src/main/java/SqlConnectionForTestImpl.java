/**
 * Created by employee on 7/22/16.
 */
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;


public class SqlConnectionForTestImpl {
    private static IDatabaseTester databaseTester;

    public Connection getConnection() throws Exception{
        databaseTester = new JdbcDatabaseTester(org.hsqldb.jdbcDriver.class
                .getName(), "jdbc:hsqldb:mem:db","","");
        return databaseTester.getConnection().getConnection();
    }

}
