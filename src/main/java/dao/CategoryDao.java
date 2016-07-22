package dao;

import entity.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by employee on 7/21/16.
 */
public class CategoryDao {

    private Connection connection;

    public CategoryDao(Connection connection) {
        this.connection=connection;
    }

    public void create(Category category) throws SQLException{
        Statement stmt = connection.createStatement();

        String resultSet = "INSERT INTO Category " +
                "(Name) "+
                "VALUES ('"+category.getCategoryName()+"')";
        stmt.executeUpdate(resultSet);
    }

    public List<Category> getAll() throws SQLException{
        List<Category> categories = new ArrayList<Category>();
        Statement stmt= connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from Category");
        while (resultSet.next()) {
            Category category = new Category();
            category.setCategoryId(resultSet.getInt("CategoryId"));
            category.setCategoryName(resultSet.getString("Name"));
            categories.add(category);
        }
        return categories;
    }

    public HashMap<Category,Integer> getNumberOfItemsInCategory(int CategoryId) throws SQLException{
        Statement stmt= connection.createStatement();
        HashMap<Category,Integer> result = new HashMap<Category, Integer>();
        ResultSet resultSet = stmt.executeQuery("select Category.CategoryId, " +
                "Category.Name, Count(Items.CategoryId) as ItemsNumber " +
                "FROM Category, Items " +
                "where CategoryId=Category.CategoryId " +
                "GROUP BY Category.CategoryId");
        while (resultSet.next()) {
            Category category = new Category();
            category.setCategoryId(resultSet.getInt("CategoryId"));
            category.setCategoryName(resultSet.getString("Name"));
            result.put(category,resultSet.getInt("ItemsNumber"));
        }
        return result;
    }

}

