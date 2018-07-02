package tinder.dao;

import java.sql.*;

class ConnectionToDB {
    // Remote PostgreSQL
    //5432 port postgres
    //3306 port mysql
    //"jdbc:postgresql";
    //"jdbc:mysql";

    // Remote MySQL
    /*String DB_URL = "jdbc:mysql://danit.cukm9c6zpjo8.us-west-2.rds.amazonaws.com:3306/fs5";
    String USERNAME = "fs5_user";
    USER_PASS = "bArceloNa";*/

    /*local postgreSQL
    port: 5432
    localhost
    user: postgres
    pass: 123
    */

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/TinderDB";
    private static final String USERNAME = "postgres";
    private static final String USER_PASS = "123";

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
