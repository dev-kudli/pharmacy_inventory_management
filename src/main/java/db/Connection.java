package db;

import java.sql.DriverManager;
import java.sql.SQLException;
import helper.constant.Database;

public abstract class Connection {
    public static java.sql.Connection con = null;
    public static java.sql.Connection getConnection(){
        if (con!=null) {
            return con;
        }
        else {
            connect();
            return con;
        }
    }
    public static void connect() {
        try {
            con = DriverManager.getConnection(
                Database.getConnectionUrl(),
                Database.getUser(),
                Database.getPassword()
            );
        } catch (SQLException e) {
            System.out.println("Unable to connect to MySql: " + e);
        }
    }
    
    public static boolean closeConnection(java.sql.Connection con) {
        boolean isClosed = false;
        try {
            con.close();
            isClosed = true;
            return isClosed;
        } catch (SQLException e) {
            return isClosed;
        }
    } 
}
