package data.mock;

import data.model.common.Date;
import data.model.pharmacy.*;
import db.*;
import java.util.ArrayList;
import java.util.List;

public class PharmacyOrderData {
    public static List<PharmacyPurchaseOrder> orders = new ArrayList<>();
    public static List<PharmacyPurchaseOrder> generatePharmacyOrders() {
        Date date = new Date(12, 31, 2022);
        
        PharmacyPurchaseOrder order1 = new PharmacyPurchaseOrder(1, 1, date);
        PharmacyOrderItem item11 = new PharmacyOrderItem(1, 5);
        PharmacyOrderItem item21 = new PharmacyOrderItem(2, 5);
        PharmacyOrderItem item31 = new PharmacyOrderItem(3, 5);

        order1.getOrderItems().add(item11);
        order1.getOrderItems().add(item21);
        order1.getOrderItems().add(item31);
        
        PharmacyPurchaseOrder order2 = new PharmacyPurchaseOrder(1, 1, date);
        PharmacyOrderItem item12 = new PharmacyOrderItem(1, 5);
        PharmacyOrderItem item22 = new PharmacyOrderItem(2, 5);
        PharmacyOrderItem item32 = new PharmacyOrderItem(3, 5);

        order2.getOrderItems().add(item12);
        order2.getOrderItems().add(item22);
        order2.getOrderItems().add(item32);
        
        orders.add(order1);
        orders.add(order2);

        return orders;
    }
    
    public static void insertOrders() throws Exception {
        for (PharmacyPurchaseOrder order : orders) {
            PharmacyManager.createOrder(order);
        }
    }
}
