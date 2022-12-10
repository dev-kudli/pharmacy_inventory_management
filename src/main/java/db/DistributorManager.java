package db;

import data.model.distributor.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DistributorManager {
    public static java.sql.Connection con = Connection.getConnection();
        public static ResultSet getShipments(int distrubutorId) throws Exception {
        try {            
            String query = """
                SELECT p.order_id, p.order_status, s.distributor_id, c1.company_name AS distributor_name, s.transporter_id, c2.company_name AS transporter_name, p.order_date
                FROM shipment s
                JOIN pharmacy_order p ON p.order_id=s.order_id
                JOIN company c1 ON s.distributor_id=c1.company_id
                JOIN company c2 ON s.transporter_id=c2.company_id
                WHERE c1.company_id=%s""";
            query = String.format(query, distrubutorId);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            throw e;
        }
    }
      
    
    public static boolean assignTransporter(int shipmentId, int transporterId) throws Exception {
        boolean isUpdated = false;
        try {            
            String queryToUpdateTransporter = """
                UPDATE shipment
                SET transporter_id=%s
                WHERE shipment_id=%s""";
            queryToUpdateTransporter = String.format(queryToUpdateTransporter, shipmentId, transporterId);
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
                SELECT tv.transporter_id, c.company_name AS transporter_name, tv.vehicle_count
                FROM transport_vehicle tv
                JOIN company c ON tv.transporter_id=c.company_id""";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryToGetVehicles);
            return rs;
        } catch (SQLException e) {
            throw e;
        }
    }
}
