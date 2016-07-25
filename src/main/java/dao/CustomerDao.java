//package dao;
//
//import entity.Customer;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Mr_Blame on 24.07.2016.
// */
//public class CustomerDao extends Dao {
//
//    public CustomerDao(Connection connection) {
//        super(connection);
//    }
//
//    public void create(Customer customer) throws SQLException {
//        Statement stmt = connection.createStatement();
//
//        String resultSet = "INSERT INTO Customers " +
//                "(CustomerName) " +
//                "VALUES ('" + customer.getCustomerName() + "')";
//        stmt.executeUpdate(resultSet);
//    }
//
//    public List<Customer> getAll() throws SQLException {
//        List<Customer> customers = new ArrayList<Customer>();
//        Statement stmt = connection.createStatement();
//        ResultSet resultSet = stmt.executeQuery("select * from Customers");
//        while (resultSet.next()) {
//            Customer customer = new Customer();
//            customer.setCustomerId(resultSet.getInt("CustomerId"));
//            customer.setCustomerName(resultSet.getString("CustomerName"));
//            customers.add(customer);
//        }
//        return customers;
//    }
//}
