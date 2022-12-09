package helper.constant;

public abstract class Database {
    private static final String JDBC_URL = "jdbc:mysql://localhost/";
    private static final String DATABASE = "pharmacy_inventory_management";
    private static final String USER = "root";
    private static final String PASSWORD = "localhost"; 
    
    public static String getConnectionUrl() {
        return JDBC_URL + DATABASE;
    }
    
    public static String getUser() {
        return USER;
    }
    
    public static String getPassword() {
        return PASSWORD;
    }
}
