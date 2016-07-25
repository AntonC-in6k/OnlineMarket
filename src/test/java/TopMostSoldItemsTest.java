import dao.*;
import entity.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Mr_Blame on 24.07.2016.
 */
public class TopMostSoldItemsTest extends CreateTables {
    private SqlConnectionForTestImpl sqlConnectionForTest;
    private CategoryDao categoryDao;
    private ItemsDao itemsDao;
    private PurchaseDao purchaseDao;
    private CustomerDao customerDao;
    private ItemsInPurchaseDao itemsInPurchaseDao;


    @Before
    public void init() throws Exception {
        sqlConnectionForTest = new SqlConnectionForTestImpl();
        createTables(sqlConnectionForTest.getConnection());
        purchaseDao = new PurchaseDao(sqlConnectionForTest.getConnection());
        customerDao = new CustomerDao(sqlConnectionForTest.getConnection());
        categoryDao = new CategoryDao(sqlConnectionForTest.getConnection());
        itemsDao = new ItemsDao(sqlConnectionForTest.getConnection());
        itemsInPurchaseDao = new ItemsInPurchaseDao(sqlConnectionForTest.getConnection());
        createDataForTables();
    }

    private void createDataForTables() throws SQLException {
        createCustomers();
        createPurchases();
        createCategories();
        createItems();
        createItemsInPurchase();
    }

    private void createCustomers() throws SQLException {
        Customer customer = new Customer();
        customer.setName("Anton");
        customerDao.create(customer);
        customer = new Customer();
        customer.setName("Karl");
        customerDao.create(customer);
    }

    private void createPurchases() throws SQLException {
        Purchase purchase = new Purchase();
        purchase.setCustomerId(0);
        purchase.setLocalDateTime(LocalDateTime.of(2016, 7, 10, 14, 04, 1));
        purchase.setCost(BigDecimal.valueOf(50.5));
        purchaseDao.create(purchase);


        purchase = new Purchase();
        purchase.setCustomerId(1);
        purchase.setLocalDateTime(LocalDateTime.of(2016, 4, 6, 14, 04, 1));
        purchase.setCost(BigDecimal.valueOf(10.0));
        purchaseDao.create(purchase);

    }

    private void createCategories() throws SQLException {
        Category testCategory = new Category();
        testCategory.setCategoryName("Mobile phone");
        categoryDao.create(testCategory);
        testCategory = new Category();
        testCategory.setCategoryName("Laptops");
        categoryDao.create(testCategory);
    }

    private void createItems() throws SQLException {
        Item testItem = new Item();
        testItem.setItemName("Iphone");
        testItem.setCategoryId(0);
        testItem.setCost(BigDecimal.valueOf(600.00));

        itemsDao.create(testItem);
        testItem = new Item();
        testItem.setItemName("Samsung Galaxy");
        testItem.setCategoryId(0);
        testItem.setCost(BigDecimal.valueOf(400.00));
        itemsDao.create(testItem);

        testItem = new Item();
        testItem.setItemName("Samsung NOTE");
        testItem.setCategoryId(0);
        testItem.setCost(BigDecimal.valueOf(500.00));
        itemsDao.create(testItem);

        testItem = new Item();
        testItem.setItemName("HTC One");
        testItem.setCategoryId(0);
        testItem.setCost(BigDecimal.valueOf(5500.00));
        itemsDao.create(testItem);

        testItem = new Item();
        testItem.setItemName("Lenovo z500");
        testItem.setCategoryId(1);
        testItem.setCost(BigDecimal.valueOf(500.00));
        itemsDao.create(testItem);
    }

    private void createItemsInPurchase() throws SQLException {

        ItemsInPurchase itemsInPurchase = new ItemsInPurchase();
        itemsInPurchase.setPurchaseId(0);
        itemsInPurchase.setItemId(0);
        itemsInPurchase.setItemsNumber(5);
        itemsInPurchase.setPrice(BigDecimal.valueOf(1800.00));
        itemsInPurchaseDao.create(itemsInPurchase);

        itemsInPurchase = new ItemsInPurchase();
        itemsInPurchase.setPurchaseId(0);
        itemsInPurchase.setItemId(1);
        itemsInPurchase.setItemsNumber(4);
        itemsInPurchase.setPrice(BigDecimal.valueOf(1000.00));
        itemsInPurchaseDao.create(itemsInPurchase);

        itemsInPurchase = new ItemsInPurchase();
        itemsInPurchase.setPurchaseId(0);
        itemsInPurchase.setItemId(2);
        itemsInPurchase.setItemsNumber(10);
        itemsInPurchase.setPrice(BigDecimal.valueOf(1500.00));
        itemsInPurchaseDao.create(itemsInPurchase);

        itemsInPurchase = new ItemsInPurchase();
        itemsInPurchase.setPurchaseId(0);
        itemsInPurchase.setItemId(3);
        itemsInPurchase.setItemsNumber(12);
        itemsInPurchase.setPrice(BigDecimal.valueOf(2000.00));
        itemsInPurchaseDao.create(itemsInPurchase);
    }

    @Test
    public void Top3MostSoldItemsTest() throws Exception {
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 5);
        expected.put(2, 10);
        expected.put(3, 12);

        assertThat(itemsDao.getTopThreeSoldItemsInCategory(0,
                LocalDateTime.of(2016, 7, 22, 14, 04, 1)), is(expected));

    }
}
