/**
 * Created by employee on 7/21/16.
 */

import dao.CategoryDao;
import dao.ItemsDao;
import entity.Category;
import entity.Item;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CategoryDaoTest extends CreateTables {
    private CategoryDao categoryDao;
    private ItemsDao itemsDao;
    private SqlConnectionForTestImpl sqlConnectionForTest;

    @Before
    public void init() throws Exception {
        sqlConnectionForTest = new SqlConnectionForTestImpl();
        createTables(sqlConnectionForTest.getConnection());
        categoryDao = new CategoryDao(sqlConnectionForTest.getConnection());
        itemsDao = new ItemsDao(sqlConnectionForTest.getConnection());
        createDataForTables();
    }


    private void createDataForTables() throws Exception {
        Category testCategory = new Category();
        testCategory.setCategoryName("Mobile phone");
        categoryDao.create(testCategory);

        testCategory = new Category();
        testCategory.setCategoryName("Laptops");
        categoryDao.create(testCategory);

        Item testItem = new Item();
        testItem.setItemName("Iphone");
        testItem.setCategoryId(0);
        testItem.setCost(BigDecimal.valueOf(500.00));
        itemsDao.create(testItem);

        testItem = new Item();
        testItem.setItemName("Samsung Galaxy");
        testItem.setCategoryId(0);
        testItem.setCost(BigDecimal.valueOf(500.00));
        itemsDao.create(testItem);

        testItem = new Item();
        testItem.setItemName("Lenovo z500");
        testItem.setCategoryId(1);
        testItem.setCost(BigDecimal.valueOf(500.00));
        itemsDao.create(testItem);
    }

    @Test
    public void getNumberOfItemsInCategoryHasSizeTwo() throws Exception {
        Map<Category, Integer> expected = new HashMap<>();
        Category category = new Category();
        category.setCategoryName("Mobile phone");
        expected.put(category, 2);

        assertThat(categoryDao.getNumberOfItemsInCategory(0), is(expected));
    }
}
