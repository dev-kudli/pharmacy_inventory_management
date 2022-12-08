package db;

import data.model.distributor.*;
import data.model.pharmacy.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PharmacyManager {
    public static java.sql.Connection con = Connection.getConnection();
    public static boolean createOrder(PharmacyPurchaseOrder order) throws Exception {
        boolean isCreated = true;
        int orderId = -1;
        try {
            String query1 = "INSERT INTO pharmacy_order(order_date, distributor_id, pharmacy_id)"
                            + "values (?, ?, ?)";
            PreparedStatement preparedStmt1 = con.prepareStatement(query1);
            preparedStmt1.setString (1, order.getPurchaseOrderDate().getFormattedDate());
            preparedStmt1.setInt (2, order.getPharmacydistributorId());
            preparedStmt1.setInt (3, order.getPharmacyCompanyId());
            preparedStmt1.execute();
            
            String query = String.format("SELECT order_id FROM pharmacy_order WHERE order_id=LAST_INSERT_ID()");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                orderId = rs.getInt("order_id");
            }
            System.out.print(orderId);

            String query2 = "INSERT INTO pharmacy_order_item(item_id, quantity, order_id)"
                            + "values (?, ?, ?)";
            PreparedStatement preparedStmt2 = con.prepareStatement(query2);
            for (PharmacyOrderItem item : order.getOrderItems()) {
                preparedStmt2.setInt (1, item.getItemId());
                preparedStmt2.setInt (2, item.getQuantity());
                preparedStmt2.setInt (3, orderId);
                preparedStmt2.addBatch();
            }

            preparedStmt2.executeBatch();
            return isCreated;
        } catch (SQLException e) {
            throw e;
        }
    }
}