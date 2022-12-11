package data.mock;

import data.model.common.Date;
import data.model.common.Drug;
import data.model.pharmacy.*;
import db.*;
import java.util.ArrayList;
import java.util.List;

public class PharmacyOrderData {
    public static List<PharmacyPurchaseOrder> orders = new ArrayList<>();
    public static List<PharmacyPurchaseOrder> generatePharmacyOrders() throws Exception {
        Date date = new Date(12, 31, 2022);
        
        Drug crocin = new Drug(1, "Crocin");
        Drug paracetamol = new Drug(2, "Paracetamol");
        
//        PharmacyPurchaseOrderItem item11 = new PharmacyPurchaseOrderItem(crocin, 5);
//        PharmacyPurchaseOrderItem item21 = new PharmacyPurchaseOrderItem(paracetamol, 2);

//        PharmacyPurchaseOrder order1 = new PharmacyPurchaseOrder(1, 1, date);
//        order1.getOrderItems().add(item11);
//        order1.getOrderItems().add(item21);

//        orders.add(order1);
        
        ManufacturerManager.updateOrder(2, "completed");
        return orders;
    }
    
    public static void insertOrder() throws Exception {
        for (PharmacyPurchaseOrder order : orders) {
            PharmacyManager.createOrder(order);
        }
    }
    
    public static void approveOrder() throws Exception {
        for (PharmacyPurchaseOrder order : orders) {
            PharmacyManager.createOrder(order);
        } 
    }
}
