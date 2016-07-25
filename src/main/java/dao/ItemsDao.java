//package dao;
//
//import entity.Item;
//
//import java.sql.*;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
///**
// * Created by Mr_Blame on 21.07.2016.
// */
//public class ItemsDao extends Dao {
//
//    public ItemsDao(Connection connection) {
//        super(connection);
//    }
//
//    public void create(Item item) throws SQLException {
//        Statement stmt = connection.createStatement();
//
//        String resultSet = "INSERT INTO Items " +
//                "(ItemName,CategoryId,Cost) " +
//                "VALUES ('" + item.getItemName() + "'," +
//                "'" + item.getCategoryId() + "'," +
//                "'" + item.getCost() + "')";
//        stmt.executeUpdate(resultSet);
//    }
//
//    public List<Item> getAll() throws SQLException {
//        List<Item> categories = new ArrayList<Item>();
//        Statement stmt = connection.createStatement();
//        ResultSet resultSet = stmt.executeQuery("select * from Items");
//        return getItems(resultSet);
//    }
//
//    private List<Item> getItems(ResultSet resultSet) throws SQLException {
//        List<Item> items = new ArrayList<Item>();
//        while (resultSet.next()) {
//            Item item = new Item();
//            item.setItemId(resultSet.getInt("ItemId"));
//            item.setItemName(resultSet.getString("ItemName"));
//            item.setCategoryId(resultSet.getInt("CategoryId"));
//            item.setCost(resultSet.getBigDecimal("Cost"));
//            items.add(item);
//        }
//        return items;
//    }
//
//    public HashMap<?, ?> getTopThreeSoldItemsInCategory(Integer id, LocalDateTime now) throws SQLException {
//        HashMap<Integer, Integer> result = new HashMap<>();
//        Statement stmt = connection.createStatement();
//        ResultSet resultSet = stmt.executeQuery("" +
//                "select top 3 Items.ItemId, SUM(ItemsInPurchase.ItemsNumber) as NumberOfSells " +
//                "from Items join ItemsInPurchase on Items.ItemId=ItemsInPurchase.ItemId " +
//                "join Purchases on Purchases.PurchaseId=ItemsInPurchase.PurchaseId " +
//                "where Items.CategoryId=" + id + " AND " +
//                "Purchases.DateTime >= DATE_SUB('" + Timestamp.valueOf(now) + "', INTERVAL 2 MONTH) " +
//                "GROUP BY ItemId " +
//                "ORDER BY NumberOfSells desc;");
//        while (resultSet.next()) {
//            result.put(resultSet.getInt("ItemId"), resultSet.getInt("NumberOfSells"));
//        }
//        return result;
//    }
//
//}
