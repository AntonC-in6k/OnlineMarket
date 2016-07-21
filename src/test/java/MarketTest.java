///**
// * Created by employee on 7/21/16.
// */
//
//import static org.junit.Assert.assertEquals;
//
//import java.io.StringReader;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import org.dbunit.IDatabaseTester;
//import org.dbunit.JdbcDatabaseTester;
//import org.dbunit.dataset.IDataSet;
//import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
//import org.dbunit.operation.DatabaseOperation;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//public class MarketTest {
//    private static Market market;
//    private static IDatabaseTester databaseTester;
//
//    @BeforeClass
//    public static void init() throws Exception {
//        databaseTester = new JdbcDatabaseTester(org.hsqldb.jdbcDriver.class
//                .getName(), "jdbc:hsqldb:file:/opt/db/testdb", "root", "");
//        createTables(databaseTester.getConnection().getConnection());
//
//        String inputXml = "<dataset>" + "    <CATEGORY CategoryID=\"1\" "
//                + "       Name=\"Mobile phone\""
//                + "       NumberOfItems=\"10\"/>"
//                + "        </dataset>";
//
//        IDataSet dataSet = new FlatXmlDataSetBuilder().build(new StringReader(inputXml));
//        databaseTester.setDataSet(dataSet);
//        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
//        databaseTester.setTearDownOperation(DatabaseOperation.DELETE_ALL);
//        databaseTester.onSetup();
//        market = new Market();
//        market.setConnection(databaseTester.getConnection().getConnection());
//
//    }
//
//    private static void createTables(Connection connection)
//            throws SQLException {
//        PreparedStatement statement = connection.prepareStatement("CREATE TABLE CATEGORY"+
//                "(CategoryId int, Name text(10), NumberOfItems int)");
//        statement.execute();
//        statement.close();
//    }
//
//    @Test
//    public void testCalculator() throws SQLException{
//        market = new Market();
//        market.setConnection();
//        assertEquals("",Market.getCategory());
//    }
//
//    @AfterClass
//    public static void cleanUp() throws Exception {
//        market=null;
//        databaseTester.onTearDown();
//        databaseTester = null;
//    }
//}
