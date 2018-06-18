package tinder.dao;

import java.sql.*;

public class ConnectionToDB {
    //5432 port postgres
    //3306 port mysql
    //"jdbc:postgresql";
    //"jdbc:mysql";
    private static final String DB_URL = "jdbc:mysql://danit.cukm9c6zpjo8.us-west-2.rds.amazonaws.com:3306/fs5";
    private static final String USERNAME = "fs5_user";
    private static final String USER_PASS = "bArceloNa";

    protected static Connection getConnection(){

        Connection connection = null;

        try
        {
            connection = DriverManager.getConnection(DB_URL, USERNAME, USER_PASS);
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }

        return connection;
    }

}
