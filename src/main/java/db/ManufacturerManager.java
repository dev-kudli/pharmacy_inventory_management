package db;

import data.model.common.Date;
import static db.PharmacyManager.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ManufacturerManager {
    public static java.sql.Connection con = Connection.getConnection();
    public static ResultSet viewAllOrders(int manufacturerId) throws Exception {
        try {
            String queryToViewOrders = String.format("SELECT * FROM distributor_order WHERE manufacturer_id=%s", manufacturerId);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryToViewOrders);
            return rs;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public static boolean updateOrder(int orderId, String status) throws Exception {
        boolean isUpdated = false;
        try {
            String queryToViewOrders = String.format("UPDATE distributor_order SET order_date=\"%s\" WHERE order_id=%s", new Date(10,13,1997).getFormattedDate(), 1);
            PreparedStatement preparedStmt1 = con.prepareStatement(queryToViewOrders);
            preparedStmt1.execute();
            return !isUpdated;
        } catch (SQLException e) {
            throw e;
        }
    }
}
