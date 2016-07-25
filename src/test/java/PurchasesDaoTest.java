///**
// * Created by employee on 7/21/16.
// */
//
//import dao.CustomerDao;
//import dao.PurchaseDao;
//import entity.Customer;
//import entity.Purchase;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.math.BigDecimal;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.assertTrue;
//
//public class PurchasesDaoTest extends CreateTables {
//    private PurchaseDao purchaseDao;
//    private CustomerDao customerDao;
//    private SqlConnectionForTestImpl sqlConnectionForTest;
//
//    @Before
//    public void init() throws Exception {
//        sqlConnectionForTest = new SqlConnectionForTestImpl();
//        createTables(sqlConnectionForTest.getConnection());
//        purchaseDao = new PurchaseDao(sqlConnectionForTest.getConnection());
//        customerDao = new CustomerDao(sqlConnectionForTest.getConnection());
//        createDataForTables();
//
//
//
//    }
//
//    private void createDataForTables() throws SQLException {
//        Customer customer = new Customer();
//        customer.setCustomerName("Anton");
//        customerDao.create(customer);
//        customer = new Customer();
//        customer.setCustomerName("Karl");
//        customerDao.create(customer);
//
//        Purchase purchase = new Purchase();
//        purchase.setCustomerId(0);
//        purchase.setLocalDateTime(LocalDateTime.of(2016, 7, 10, 14, 04, 1));
//        purchase.setCost(BigDecimal.valueOf(50.5));
//        purchaseDao.create(purchase);
//
//        purchase = new Purchase();
//        purchase.setCustomerId(0);
//        purchase.setLocalDateTime(LocalDateTime.of(2016, 7, 6, 14, 04, 1));
//        purchase.setCost(BigDecimal.valueOf(10.0));
//        purchaseDao.create(purchase);
//
//        purchase = new Purchase();
//        purchase.setCustomerId(1);
//        purchase.setLocalDateTime(LocalDateTime.of(2015, 7, 6, 14, 04, 1));
//        purchase.setCost(BigDecimal.valueOf(10.0));
//        purchaseDao.create(purchase);
//
//        purchase = new Purchase();
//        purchase.setCustomerId(1);
//        purchase.setLocalDateTime(LocalDateTime.of(2016, 7, 6, 14, 04, 1));
//        purchase.setCost(BigDecimal.valueOf(10.0));
//        purchaseDao.create(purchase);
//
//    }
//
//    @Test
//    public void hasRecord() throws Exception {
//
//        List<Purchase> testCategories = purchaseDao.getPurchasesForCustomer(0);
//        List<Purchase> expected = new ArrayList<>();
//        Purchase expectedPurchase = new Purchase();
//        expectedPurchase.setPurchaseId(0);
//        expectedPurchase.setLocalDateTime(LocalDateTime.of(2016, 7, 10, 14, 04, 1));
//        expectedPurchase.setCost(new BigDecimal("50.50"));
//        expected.add(expectedPurchase);
//        expectedPurchase = new Purchase();
//        expectedPurchase.setPurchaseId(1);
//        expectedPurchase.setLocalDateTime(LocalDateTime.of(2016, 7, 6, 14, 04, 1));
//        expectedPurchase.setCost(new BigDecimal("10.00"));
//        expected.add(expectedPurchase);
//
//        assertTrue(testCategories.get(0).toString().contains(expected.get(0).toString()));
//        assertTrue(testCategories.get(1).toString().contains(expected.get(1).toString()));
//
//    }
//
//}
