package dao;

import entity.ItemsInPurchase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr_Blame on 24.07.2016.
 */
public class ItemsInPurchaseDao extends Dao {

    public ItemsInPurchaseDao(Connection connection) {
        super(connection);
    }

    public void create(ItemsInPurchase itemsInPurchase) throws SQLException {
        Statement stmt = connection.createStatement();

        String resultSet = "INSERT INTO ItemsInPurchase " +
                "(PurchaseId, ItemId, ItemsNumber, Price) " +
                "VALUES ('"+itemsInPurchase.getPurchaseId() +"'," +
                "'" + itemsInPurchase.getItemId() + "'," +
                "'" + itemsInPurchase.getItemsNumber() + "'," +
                "'" + itemsInPurchase.getPrice() + "')";
        stmt.executeUpdate(resultSet);
    }

    public List<ItemsInPurchase> getAll() throws SQLException {
        List<ItemsInPurchase> itemsInPurchases = new ArrayList<ItemsInPurchase>();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from ItemsInPurchase");
        while (resultSet.next()) {
            ItemsInPurchase itemsInPurchase = new ItemsInPurchase();
            itemsInPurchase.setPurchaseId(resultSet.getInt("PurchaseId"));
            itemsInPurchase.setItemId(resultSet.getInt("PurchaseId"));
            itemsInPurchase.setItemsNumber(resultSet.getInt("ItemsNumber"));
            itemsInPurchase.setPrice(resultSet.getBigDecimal("Price"));
            itemsInPurchases.add(itemsInPurchase);
        }
        return itemsInPurchases;
    }

    public List<ItemsInPurchase> getItemsInPurchaseByIndex(Integer id) throws SQLException {
        List<ItemsInPurchase> itemsInPurchases = new ArrayList<ItemsInPurchase>();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("select ItemId, ItemsNumber, " +
                "Price from ItemsInPurchase " +
                "where PurchaseId=" + id + ";");
        while (resultSet.next()) {
            ItemsInPurchase itemsInPurchase = new ItemsInPurchase();
            itemsInPurchase.setItemId(resultSet.getInt("ItemId"));
            itemsInPurchase.setItemsNumber(resultSet.getInt("ItemsNumber"));
            itemsInPurchase.setPrice(resultSet.getBigDecimal("Price"));
            itemsInPurchases.add(itemsInPurchase);
        }
        return itemsInPurchases;
    }
}
