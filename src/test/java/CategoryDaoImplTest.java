/**
 * Created by employee on 7/21/16.
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
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CategoryDaoImplTest {
    private static CategoryDaoImpl categoryDao;
    private static IDatabaseTester databaseTester;

    @BeforeClass
    public static void init() throws Exception {
        databaseTester = new JdbcDatabaseTester(org.hsqldb.jdbcDriver.class
                .getName(), "jdbc:hsqldb:file:~/Desktop/testdb/");
        createTables(databaseTester.getConnection().getConnection());

        String inputXml = "<dataset>"
                + "   <Category CategoryID=\"1\""
                + "       Name=\"Mobile phone\""
                + "       NumberOfItems=\"10\"/>"
                + "        </dataset>";
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(new StringReader(inputXml));
        databaseTester.setDataSet(dataSet);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setTearDownOperation(DatabaseOperation.DELETE_ALL);
        databaseTester.onSetup();
        categoryDao = new CategoryDaoImpl(databaseTester.getConnection().getConnection());
    }

    private static void createTables(Connection connection)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement("CREATE TABLE Category"+
                "(CategoryId int, Name varchar(100), NumberOfItems int)");
        statement.execute();
        statement.close();
    }

    @Test
    public void hasRecord() throws Exception {
        Category testCategory = new Category();
        testCategory.setId(2);
        testCategory.setName("Laptop");
        testCategory.setNumberOfItems(20);
        categoryDao.setRecord(testCategory);
        List<Category> testCategories = categoryDao.getAll();
        assertThat(testCategories.get(1).getName(),is("Laptop"));
    }

    @AfterClass
    public static void cleanUp() throws Exception {
        databaseTester.onTearDown();
        databaseTester = null;
    }
}
