import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 7/21/16.
 */
public class CategoryDaoImpl {

    private SqlConnection sqlConnection;
    private Connection connection;

    public CategoryDaoImpl(Connection connection) {
        this.connection=connection;
    }

    public void setRecord(Category category) throws SQLException{
        Statement stmt = connection.createStatement();

        String resultSet = "INSERT INTO category " +
                "(CategoryId,Name,NumberOfItems) "+
                "VALUES ('"+category.getId()+"'," +
                "'"+category.getName()+"'," +
                "'"+category.getNumberOfItems()+"')";

        stmt.executeUpdate(resultSet);
    }


    public List<Category> getAll() throws SQLException{
        List<Category> categories = new ArrayList<Category>();
        Statement stmt= connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from CATEGORY");
        while (resultSet.next()) {
            Category category = new Category();
            category.setId(resultSet.getInt("CategoryId"));
            category.setName(resultSet.getString("Name"));
            category.setNumberOfItems(resultSet.getInt("NumberOfItems"));
            categories.add(category);

        }
        return categories;
    }


}

