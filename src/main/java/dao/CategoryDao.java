package dao;

import entity.Category;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    private Session session;

    public CategoryDao(Session session) {
        this.session = session;
    }

    public HashMap<Category, Integer> getNumberOfItemsInCategory(int CategoryId) throws SQLException {

        HashMap<Category, Integer> result = new HashMap<>();
        List<Category> categories = null;
        String query = "FROM Category";
        Transaction tx = null;
        tx = session.beginTransaction();
        categories = session.createQuery(query).list();
        tx.commit();
        for (Category category : categories) {
            result.put(category, category.getItems().size());
        }

        return result;
    }
}

