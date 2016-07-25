package dao;

import entity.Purchase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr_Blame on 21.07.2016.
 */
public class PurchaseDao extends Dao {

    public PurchaseDao(Connection connection) {
        super(connection);
    }

    public void create(Purchase purchase) throws SQLException {
        Statement stmt = connection.createStatement();

        String resultSet = "INSERT INTO Purchases " +
                "(CustomerId,DateTime,Cost) " +
                "VALUES ('" + purchase.getCustomerId() + "'," +
                "'" + Timestamp.valueOf(purchase.getLocalDateTime()) + "'," +
                "'" + purchase.getCost() + "')";
        stmt.executeUpdate(resultSet);
    }

    public List<Purchase> getAll() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from Purchases");
        return getPurchases(resultSet);
    }

    private List<Purchase> getPurchases(ResultSet resultSet) throws SQLException {
        List<Purchase> result = new ArrayList<Purchase>();
        while (resultSet.next()) {
            Purchase purchase = new Purchase();
            purchase.setPurchaseId(resultSet.getInt("PurchaseId"));
            purchase.setCustomerId(resultSet.getInt("CustomerId"));
            purchase.setLocalDateTime(resultSet.getTimestamp("DateTime").toLocalDateTime());
            purchase.setCost(resultSet.getBigDecimal("Cost"));
            result.add(purchase);
        }
        return result;
    }

    public List<Purchase> getPurchasesForCustomer(Integer customerId) throws SQLException {
        List<Purchase> purchases = new ArrayList<Purchase>();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("select PurchaseId, " +
                "DateTime,Cost " +
                "from Purchases WHERE CustomerId=" + customerId + ";");
        while (resultSet.next()) {
            Purchase purchase = new Purchase();
            purchase.setPurchaseId(resultSet.getInt("PurchaseId"));
            purchase.setLocalDateTime(resultSet.getTimestamp("DateTime").toLocalDateTime());
            purchase.setCost(resultSet.getBigDecimal("Cost"));
            purchases.add(purchase);
        }
        return purchases;
    }
}

