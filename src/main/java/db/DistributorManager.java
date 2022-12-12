package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DistributorManager {
    public static java.sql.Connection con = Connection.getConnection();
        public static ResultSet getShipments(int distrubutorId) throws Exception {
        try {            
            String query = """
                SELECT p.order_id, p.order_status, p.manufacturer_id, c1.company_name AS distributor_name, p.transporter_id, c2.company_name AS transporter_name, p.order_date
                FROM pharmacy_order p
                LEFT OUTER JOIN company c1 ON p.distributor_id=c1.company_id
                LEFT OUTER JOIN company c2 ON p.transporter_id=c2.company_id
                WHERE p.distributor_id=%s""";
            query = String.format(query, distrubutorId);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            throw e;
        }
    }
      
    
    public static boolean assignTransporter(int orderId, int transporterId) throws Exception {
        boolean isUpdated = false;
        try {            
            String queryToUpdateTransporter = """
                UPDATE pharmacy_order
                SET transporter_id=%s,
                order_status="TRANSPORTING"
                WHERE order_id=%s""";
            queryToUpdateTransporter = String.format(queryToUpdateTransporter, transporterId, orderId);
            Statement stmt = con.createStatement();
            int count = stmt.executeUpdate(queryToUpdateTransporter);
            if (count>0) return !isUpdated;
            else return isUpdated;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public static ResultSet getTransporterVehicles() throws Exception {
        try {            
            String queryToGetVehicles = """
                SELECT c.company_id as transporter_id, c.company_name AS transporter_name, tv.vehicle_count
                FROM company c
                left outer join transport_vehicle tv on c.company_id=tv.transporter_id
                where c.company_type=\"TRANSPORTER\"""";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryToGetVehicles);
            return rs;
        } catch (SQLException e) {
            throw e;
        }
    }
}
