package dao;

import entity.Items;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr_Blame on 21.07.2016.
 */
public class ItemsDao {
    private Connection connection;

    public ItemsDao(Connection connection) {
        this.connection=connection;
    }

    public void create(Items items) throws SQLException {
        Statement stmt = connection.createStatement();

        String resultSet = "INSERT INTO Items " +
                "(ItemName,CategoryId,Cost,NumberOfSells) "+
                "VALUES ('"+items.getItemName()+"'," +
                "'"+items.getCategoryId()+"'," +
                "'"+items.getCost()+"',"+
                "'"+items.getNumberOfSells()+"')";
        stmt.executeUpdate(resultSet);
    }

    public List<Items> getAll() throws SQLException{
        List<Items> categories = new ArrayList<Items>();
        Statement stmt= connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from Items");
        return getCategories(resultSet);
    }

    private List<Items> getCategories(ResultSet resultSet)throws SQLException{
        List<Items> items = new ArrayList<Items>();
        while (resultSet.next()) {
            Items item = new Items();
            item.setItemId(resultSet.getInt("ItemId"));
            item.setItemName(resultSet.getString("ItemName"));
            item.setCategoryId(resultSet.getInt("CategoryId"));
            item.setCost(resultSet.getBigDecimal("Cost"));
            item.setNumberOfSells(resultSet.getInt("NumberOfSells"));
            items.add(item);
        }
        return items;
    }
}
