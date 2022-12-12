package db;

import data.model.pharmacy.PharmacyPurchaseOrder;
import data.model.pharmacy.PharmacyPurchaseOrderItem;
import helper.constant.CompanyTypes;
import helper.constant.UserRole;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ManufacturerManager {
    private final static String FILENAME = "ManufacturerManager";
    public static java.sql.Connection con = Connection.getConnection();
    /**
     * @param orderId - ID of the Order
     * @param status - Status of the order (Refer constants file to read values)
     * @return true if operation succeeds
     * @throws java.lang.Exception
     */
    public static boolean updateOrder(int orderId, String status) throws Exception {
        boolean isUpdated = false;
        try {
            String queryToUpdateOrder = "UPDATE pharmacy_order SET order_status=\"%s\" WHERE order_id=%s";
            queryToUpdateOrder = String.format(queryToUpdateOrder, status, orderId);
            PreparedStatement preparedStmt = con.prepareStatement(queryToUpdateOrder);
            preparedStmt.execute();
            
            PharmacyPurchaseOrder order = CommonFunctions.getOrderFromOrderId(orderId);
            ManufacturerManager.updateStock(order);
            return !isUpdated;
        } catch (SQLException e) {
            throw new Exception(FILENAME + "->" + "updateOrder" + "->" + e);
        }
    }
    
    /**
     * @param orderId - ID of the Order
     * @param distributorId - Distributor ID
     * @return int - Number of records updated
     * @throws java.lang.Exception
     */
    public static int assignDistributor(int orderId, int distributorId) throws Exception {
        try {
            String queryToAssignDistributor = "UPDATE pharmacy_order SET distributor_id=%s WHERE order_id=%s";
            queryToAssignDistributor = String.format(queryToAssignDistributor, distributorId, orderId);
            Statement stmt = con.createStatement();
            return stmt.executeUpdate(queryToAssignDistributor);
        } catch (SQLException e) {
            throw new Exception(FILENAME + "->" + "assignDistributor" + "->" + e);
        }
    }
    
    /**
     * @return ResultSet
     * @throws java.lang.Exception
     */
    public static ResultSet viewAllDistributors() throws Exception {
        try {
            String queryToFetchDistributors = """
                SELECT company_id, company_name
                FROM company
                WHERE company_type=\"%s\"""";
            queryToFetchDistributors = String.format(queryToFetchDistributors, CompanyTypes.DISTRIBUTOR);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryToFetchDistributors);
            return rs;
            
        } catch (SQLException e) {
            throw new Exception(FILENAME + "->" + "viewAllDistributors" + "->" + e);
        }
    }
    
    /**
     * @param order - Order class
     * @return true if operation succeeds
     * @throws java.lang.Exception
     */
    public static boolean updateStock(PharmacyPurchaseOrder order) throws Exception {
        boolean isUpdated = false;
        try {
            for (PharmacyPurchaseOrderItem item : order.getOrderItems()) {
                System.out.println(item.getDrug().getDrugId()+"by"+item.getQuantity());
                String queryToUpdateOrder = "UPDATE manufacturer_inventory SET quantity=quantity-%s WHERE drug_id=%s AND manufacturer_id=%s";
                queryToUpdateOrder = String.format(queryToUpdateOrder, item.getQuantity(), item.getDrug().getDrugId(), order.getPharmacymanufactureId());
                PreparedStatement preparedStmt = con.prepareStatement(queryToUpdateOrder);
                preparedStmt.execute();
            }
            return !isUpdated;
        } catch (SQLException e) {
            throw new Exception(FILENAME + "->" + "updateStock" + "->" + e);
        }
    }
    
    /**
     * @param manufacturerId - ID of the Manufacturer
     * @return ResultSet if operation succeeds
     * @throws java.lang.Exception
     */
    public static ResultSet fetchAllOrders(int manufacturerId) throws Exception {
        try {
            //Build Query
            String query = """
                SELECT po.order_id, po.pharmacy_id, c.company_name AS pharmacy_name, po.order_date, po.order_status, COUNT(poi.item_id) AS total_items, po.distributor_id, c2.company_name as distributor_name, SUM(poi.cost_price*poi.quantity) AS total_price
                FROM pharmacy_order po
                JOIN company c ON c.company_id=po.pharmacy_id
                LEFT OUTER JOIN company c2 ON c2.company_id=po.distributor_id
                JOIN pharmacy_order_item poi ON poi.order_id = po.order_id
                WHERE po.manufacturer_id=%s
                GROUP BY po.order_id, po.order_date, po.order_status""";
            query = String.format(query, manufacturerId);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    /**
     * @param orderId - Order ID
     * @return ResultSet if operation succeeds
     * @throws java.lang.Exception
     */
    public static ResultSet fetchAllOrderItems(int orderId) throws Exception {
        try {
            //Build Query
            String query = """
                SELECT poi.item_id, md.drug_name, poi.quantity, poi.cost_price*poi.quantity AS unit_price
                FROM pharmacy_order po
                JOIN company c ON c.company_id=po.manufacturer_id
                JOIN pharmacy_order_item poi ON poi.order_id = po.order_id
                JOIN master_drug_table md ON md.drug_id=poi.item_id
                WHERE po.order_id=%s""";
            query = String.format(query, orderId);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    /**
     * @param manufacturerId - ID of the Manufacturer
     * @return ResultSet if operation succeeds
     * @throws java.lang.Exception
     */
    public static ResultSet fetchStock(int manufacturerId) throws Exception {
        try {
            String query = """
                SELECT mi.drug_id, mi.quantity, md.drug_name, selling_price 
                FROM manufacturer_inventory mi
                JOIN master_drug_table md ON md.drug_id=mi.drug_id
                WHERE manufacturer_id=%s""";
            query = String.format(query, manufacturerId);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            throw new Exception(FILENAME + "->" + "fetchStock" + "->" + e);
        }
    }
    
    /**
     * @param manufacturerId - ID of the Manufacturer
     * @return ResultSet if operation succeeds
     * @throws java.lang.Exception
     */
    public static ResultSet getYearlyReport(int manufacturerId, int year) throws Exception {
        try {
            String query = """
                SELECT po.order_id, po.pharmacy_id, c.company_name AS pharmacy_name, po.order_date, po.order_status, COUNT(poi.item_id) AS total_items, po.distributor_id, c2.company_name as distributor_name, SUM(poi.cost_price*poi.quantity) AS total_price
                FROM pharmacy_order po
                JOIN company c ON c.company_id=po.pharmacy_id
                LEFT OUTER JOIN company c2 ON c2.company_id=po.distributor_id
                JOIN pharmacy_order_item poi ON poi.order_id = po.order_id
                WHERE po.manufacturer_id=%s AND YEAR(order_date)=%s
                GROUP BY po.order_id, po.order_date, po.order_status""";
            query = String.format(query, manufacturerId, year);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            throw new Exception(FILENAME + "->" + "fetchStock" + "->" + e);
        }
    }
}
