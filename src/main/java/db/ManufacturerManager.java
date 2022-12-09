package db;

import data.model.pharmacy.PharmacyPurchaseOrder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ManufacturerManager {
    private final static String FILENAME = "ManufacturerManager";
    public static java.sql.Connection con = Connection.getConnection();
    /**
     * @param order - Order Class
     * @param status - Status of the order (Refer constants file to read values)
     * @return true if operation succeeds
     * @throws java.lang.Exception
     */
    public static boolean updateOrder(PharmacyPurchaseOrder order, String status) throws Exception {
        boolean isUpdated = false;
        try {
            String queryToUpdateOrder = String.format("UPDATE distributor_order SET order_status=\"%s\" WHERE order_id=%s", status, order.getOrderId());
            PreparedStatement preparedStmt = con.prepareStatement(queryToUpdateOrder);
            preparedStmt.execute();
            PharmacyManager.updateStockAndQuantity(order);
            return !isUpdated;
        } catch (SQLException e) {
            throw new Exception(FILENAME + "->" + "updateOrder" + "->" + e);
        }
    }
    
    /**
     * @param drugId - ID of an Drug
     * @param manufacturerId - ID of the Manufacturer
     * @param quantity - Quantity to add/subtract
     * @param operation - Takes "add" or "subtract" values
     * @return true if operation succeeds
     * @throws java.lang.Exception
     */
    public static boolean updateStock(int drugId, int manufacturerId, int quantity, String operation) throws Exception {
        boolean isUpdated = false;
        String op = null;
        switch (operation) {
            case "add" -> op = "+";
            case "sub" -> op = "-";
            default -> throw new Exception("Invalid operand");
        }
        try {
            String queryToUpdateOrder;
            queryToUpdateOrder = String.format("UPDATE manufacturer_inventory SET quantity=quantity%s%s WHERE drug_id=%s AND manufacturer_id=%s", op, quantity, drugId, manufacturerId);
            PreparedStatement preparedStmt = con.prepareStatement(queryToUpdateOrder);
            preparedStmt.execute();
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
                           SELECT po.order_id, po.pharmacy_id, c.company_name as pharmacy_name, po.order_date, po.order_status
                           FROM pharmacy_order po
                           join company c on c.company_id=po.pharmacy_id
                           WHERE po.manufacturer_id=%s""";
            query = String.format(query, manufacturerId);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            throw e;
        } 
    }
}
