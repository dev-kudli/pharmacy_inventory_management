package db;

import static db.PersonManager.con;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class TransportManager {
    public static boolean confirmShipmentStatus(int shipmentId) throws Exception {
        boolean isShipped = false;
        try {
            String queryToUpdateStatus = """
                UPDATE shipment
                SET shipment_status=\"delivered\"
                WHERE shipment_id=%s""";
            queryToUpdateStatus = String.format(queryToUpdateStatus, shipmentId);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(queryToUpdateStatus);
            
            PharmacyManager.updateStockAndQuantity(shipmentId);
        } catch (SQLException e) {
            throw e;
        }
    }
    public static ResultSet fetchAllShipments(int transporterId) throws Exception {
        try {
            String queryToFetchShipments = """
                SELECT s.shipment_id, p.order_date, p.pharmacy_id, c1.company_name AS pharmacy_name, c2.company_name AS distributor_name, s.shipment_status
                FROM shipment s
                JOIN pharmacy_order p ON p.order_id=s.order_id
                JOIN company c1 ON p.pharmacy_id=c1.company_id
                JOIN company c2 ON s.distributor_id=c1.company_id
                WHERE c1.transporter_id=%s""";
            queryToFetchShipments = String.format(queryToFetchShipments, transporterId);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryToFetchShipments);
            return rs;
        } catch (SQLException e) {
            throw e;
        }
    }
}
