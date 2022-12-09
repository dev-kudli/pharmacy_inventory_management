package db;

import data.model.common.Date;
import data.model.pharmacy.*;
import helper.string.StringCustomMethods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class PharmacyManager {
    public static java.sql.Connection con = Connection.getConnection();
    public static boolean createOrder(PharmacyPurchaseOrder order) throws Exception {
        boolean isCreated = true;
        int orderId = -1;
        try {
            try {
                //Query to insert Order
                order.setOrderStatus("placed");
                String queryToInsertOrder = "INSERT INTO pharmacy_order(order_date, distributor_id, pharmacy_id)"
                                + "values (?, ?, ?)";
                PreparedStatement preparedStmt1 = con.prepareStatement(queryToInsertOrder);
                preparedStmt1.setString (1, order.getPurchaseOrderDate().getFormattedDate());
                preparedStmt1.setInt (2, order.getPharmacymanufactureId());
                preparedStmt1.setInt (3, order.getPharmacyCompanyId());
                preparedStmt1.execute();
            } catch (SQLException e) {
                throw new Exception("Error inserting order: " + e);
            }
            
            try {
                //Query to get Order ID
                String queryToGetOrderId = String.format("SELECT order_id FROM pharmacy_order WHERE order_id=LAST_INSERT_ID()");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(queryToGetOrderId);
                if (rs.next()) {
                    orderId = rs.getInt("order_id");
                } else {
                    throw new Error("Cannot find ID");
                }
            } catch (SQLException e) {
                throw new Exception("Error fetching order ID: " + e);
            }
            
            try {
                //Query to insert Order Items
                String queryToInsertOrderItems = "INSERT INTO pharmacy_order_item(item_id, quantity, order_id)"
                                + "values (?, ?, ?)";
                PreparedStatement preparedStmt2 = con.prepareStatement(queryToInsertOrderItems);
                for (PharmacyOrderItem item : order.getOrderItems()) {
                    preparedStmt2.setInt (1, item.getItemId());
                    preparedStmt2.setInt (2, item.getQuantity());
                    preparedStmt2.setInt (3, orderId);
                    preparedStmt2.addBatch();
                }
                preparedStmt2.executeBatch();
            } catch (SQLException e) {
                throw new Exception("Error inserting order items: " + e);
            }
            return isCreated;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public static ResultSet fetchAllOrders(int pharmacyCompanyId) throws Exception {
        try {
            //Build Query
            String query = String.format("SELECT * FROM pharmacy_order WHERE pharmacy_id=%s", pharmacyCompanyId);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            throw e;
        } 
    }
    
    public static ResultSet fetchAllOrdersByManufacturerId(int pharmacyCompanyId) throws Exception {
        try {
            //Build Query
            String query = String.format("SELECT * FROM pharmacy_order WHERE pharmacy_id=%s", pharmacyCompanyId);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            throw e;
        } 
    }
    
    public static ResultSet displayManufacturerInventory() throws Exception {
        try {
            String query = """
                SELECT m.manufacturer_id, c.company_name AS manufacturer_name, d.drug_id, d.drug_name, m.quantity, m.selling_price
                FROM manufacturer_inventory m
                JOIN master_drug_table d on m.drug_id = d.drug_id
                JOIN company c on m.manufacturer_id = c.company_id;""";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            throw e;
        } 
    }
}