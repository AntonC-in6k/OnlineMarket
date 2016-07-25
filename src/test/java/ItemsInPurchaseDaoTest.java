import dao.*;
import entity.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Mr_Blame on 24.07.2016.
 */
public class ItemsInPurchaseDaoTest extends CreateTables {
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
        purchase.setCustomerId(customerDao.getAll().get(0).getId());
        purchase.setLocalDateTime(LocalDateTime.of(2016, 7, 10, 14, 04, 1));
        purchase.setCost(BigDecimal.valueOf(50.5));
        purchaseDao.create(purchase);
        purchase = new Purchase();
        purchase.setCustomerId(customerDao.getAll().get(0).getId());
        purchase.setLocalDateTime(LocalDateTime.of(2016, 7, 6, 14, 04, 1));
        purchase.setCost(BigDecimal.valueOf(10.0));
        purchaseDao.create(purchase);
        purchase = new Purchase();
        purchase.setCustomerId(customerDao.getAll().get(1).getId());
        purchase.setLocalDateTime(LocalDateTime.of(2016, 7, 6, 14, 04, 1));
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
        testItem.setCategoryId(categoryDao.getAll().get(0).getCategoryId());
        testItem.setCost(BigDecimal.valueOf(600.00));
        itemsDao.create(testItem);

        testItem = new Item();
        testItem.setItemName("Samsung Galaxy");
        testItem.setCategoryId(categoryDao.getAll().get(0).getCategoryId());
        testItem.setCost(BigDecimal.valueOf(500.00));
        itemsDao.create(testItem);

        testItem = new Item();
        testItem.setItemName("Lenovo z500");
        testItem.setCategoryId(categoryDao.getAll().get(1).getCategoryId());
        testItem.setCost(BigDecimal.valueOf(500.00));
        itemsDao.create(testItem);
    }

    private void createItemsInPurchase() throws SQLException {
        ItemsInPurchase itemsInPurchase = new ItemsInPurchase();
        itemsInPurchase.setPurchaseId(0);
        itemsInPurchase.setItemId(0);
        itemsInPurchase.setItemsNumber(3);
        itemsInPurchase.setPrice(BigDecimal.valueOf(1800.00));
        itemsInPurchaseDao.create(itemsInPurchase);

        itemsInPurchase = new ItemsInPurchase();
        itemsInPurchase.setPurchaseId(1);
        itemsInPurchase.setItemId(2);
        itemsInPurchase.setItemsNumber(1);
        itemsInPurchase.setPrice(BigDecimal.valueOf(500.00));
        itemsInPurchaseDao.create(itemsInPurchase);
    }

    @Test
    public void returnItemsInPurchaseByIndex() throws Exception {
        ItemsInPurchase expected = new ItemsInPurchase();
        expected.setItemId(0);
        expected.setItemsNumber(3);
        expected.setPrice(new BigDecimal("1800.00"));

        assertThat(itemsInPurchaseDao.getItemsInPurchaseByIndex(0).get(0), is(expected));

    }
}
