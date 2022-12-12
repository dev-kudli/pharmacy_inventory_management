package db;

import data.model.pharmacy.PharmacyPurchaseOrder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class TransportManager {
    public static java.sql.Connection con = Connection.getConnection();
    public static boolean confirmShipmentStatus(int orderId) throws Exception {
        System.out.println("backend order id: "+orderId);
        boolean isShipped = false;
        try {
            String queryToUpdateStatus = """
                UPDATE pharmacy_order
                SET order_status=\"DELIVERED\"
                WHERE order_id=%s""";
            queryToUpdateStatus = String.format(queryToUpdateStatus, orderId);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(queryToUpdateStatus);
            
            PharmacyPurchaseOrder order = CommonFunctions.getOrderFromOrderId(orderId);
            PharmacyManager.updateStockAndQuantity(order);
            return !isShipped;
        } catch (SQLException e) {
            throw e;
        }
    }
    public static ResultSet fetchAllShipments(int transporterId) throws Exception {
        try {
            String queryToFetchShipments = """
                SELECT po.order_id, po.order_date, po.pharmacy_id, po.distributor_id, c1.company_name AS pharmacy_name, po.order_status, c2.company_name as distributor_name
                FROM pharmacy_order po
                LEFT OUTER JOIN company c1 ON po.pharmacy_id=c1.company_id
                LEFT OUTER JOIN company c2 ON po.distributor_id=c2.company_id
                WHERE po.transporter_id=%s""";
            queryToFetchShipments = String.format(queryToFetchShipments, transporterId);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryToFetchShipments);
            return rs;
        } catch (SQLException e) {
            throw e;
        }
    }
}
