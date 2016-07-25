/**
 * Created by employee on 7/21/16.
 */

import com.fasterxml.classmate.AnnotationConfiguration;
import dao.CategoryDao;
//import dao.ItemsDao;
import entity.Category;
import entity.Item;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CategoryDaoTest extends CreateTables {
    private CategoryDao categoryDao;
//    private ItemsDao itemsDao;
    private SqlConnectionForTestImpl sqlConnectionForTest;
    private SessionFactory sessionFactory;
    private Session session = null;

    @Before
    public void init() throws Exception {
        sqlConnectionForTest = new SqlConnectionForTestImpl();
        createTables(sqlConnectionForTest.getConnection());
        fillTables(sqlConnectionForTest.getConnection());
        SessionFactory factory =  new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
//        createDataForTables();

    }

    private void createDataForTables() throws Exception {

        Category testCategory = new Category();
        testCategory.setCategoryName("Mobile phone");
        session.save(testCategory);

        Item testItem = new Item();
        testItem.setItemName("Iphone");
        testItem.setCategoryId(testCategory);
        testItem.setCost(BigDecimal.valueOf(500.00));

        session.save(testItem);
        session.flush();

        testItem = new Item();
        testItem.setItemName("Samsung Galaxy");
        testItem.setCategoryId(testCategory);
        testItem.setCost(BigDecimal.valueOf(500.00));

        session.save(testItem);

        testCategory = new Category();
        testCategory.setCategoryName("Laptops");

        testItem = new Item();
        testItem.setItemName("Lenovo z500");
        testItem.setCategoryId(testCategory);
        testItem.setCost(BigDecimal.valueOf(500.00));

        session.save(testCategory);
        session.save(testItem);


    }

    @Test
    public void getNumberOfItemsInCategoryHasSizeTwo() throws Exception {
//        HashMap<Category, Integer> testHashMap = new HashMap<>();
//        categoryDao = new CategoryDao(session);
//        assertThat(categoryDao.getNumberOfItemsInCategory(0).size(), is(2));

    }
}
