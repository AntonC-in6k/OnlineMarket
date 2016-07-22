package dao;

import entity.PurchaseRoster;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr_Blame on 21.07.2016.
 */
public class PurchaseRosterDao {
    private Connection connection;

    public PurchaseRosterDao(Connection connection) {
        this.connection=connection;
    }

    public void create(PurchaseRoster purchaseRoster) throws SQLException {
        Statement stmt = connection.createStatement();

        String resultSet = "INSERT INTO PurchaseRoster " +
                "(CustomerId,Date,Time,Cost) "+
                "VALUES ('"+ purchaseRoster.getCustomerId()+"'," +
                "'"+ purchaseRoster.getDate()+"',"+
                "'"+ purchaseRoster.getTime()+"'," +
                "'"+ purchaseRoster.getCost()+"')";
        stmt.executeUpdate(resultSet);
    }

    public List<PurchaseRoster> getAll() throws SQLException{
        Statement stmt= connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from PurchaseRoster");
        return getPurchaseRoster(resultSet);
    }

    private List<PurchaseRoster> getPurchaseRoster(ResultSet resultSet)throws SQLException {
        List<PurchaseRoster> result = new ArrayList<PurchaseRoster>();
        while (resultSet.next()) {
            PurchaseRoster purchaseRoster = new PurchaseRoster();
            purchaseRoster.setPurchaseId(resultSet.getInt("PurchaseId"));
            purchaseRoster.setCustomerId(resultSet.getInt("CustomerId"));
            purchaseRoster.setDate(resultSet.getDate("Date"));
            purchaseRoster.setTime(resultSet.getTime("Time"));
            purchaseRoster.setCost(resultSet.getBigDecimal("Cost"));
            result.add(purchaseRoster);
        }
        return result;
    }


    public List<PurchaseRoster> getForCustomer(Integer customerId) throws SQLException{
        List<PurchaseRoster> purchaseRosters = new ArrayList<PurchaseRoster>();
        Statement stmt= connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("select PurchaseId,Date,Time,Cost " +
                "from PurchaseRoster WHERE CustomerId="+customerId+";");
        while (resultSet.next()) {
            PurchaseRoster purchaseRoster = new PurchaseRoster();
            purchaseRoster.setPurchaseId(resultSet.getInt("PurchaseId"));
            purchaseRoster.setDate(resultSet.getDate("Date"));
            purchaseRoster.setTime(resultSet.getTime("Time"));
            purchaseRoster.setCost(resultSet.getBigDecimal("Cost"));
            purchaseRosters.add(purchaseRoster);
        }
        return purchaseRosters;
    }
}
