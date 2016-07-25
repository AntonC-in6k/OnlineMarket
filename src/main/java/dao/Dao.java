package dao;

import java.sql.Connection;

/**
 * Created by Mr_Blame on 24.07.2016.
 */
public abstract class Dao {
    protected Connection connection;

    public Dao(Connection connection) {
        this.connection = connection;
    }

}
