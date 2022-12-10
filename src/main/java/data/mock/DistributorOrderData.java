package data.mock;

import data.model.common.Date;
import data.model.distributor.*;
import db.DistributorManager;
import java.util.ArrayList;
import java.util.List;

public abstract class DistributorOrderData {
    public static List<DistributorOrder> orders = new ArrayList<>();
    public static List<DistributorOrder> generateDistributorOrders() {
        Date date = new Date(12, 31, 2022);
        
        DistributorOrder order1 = new DistributorOrder(1, 1, date);
        DistributorOrderItem item11 = new DistributorOrderItem(1, 5);
        DistributorOrderItem item21 = new DistributorOrderItem(2, 5);
        DistributorOrderItem item31 = new DistributorOrderItem(3, 5);

        order1.getOrderItems().add(item11);
        order1.getOrderItems().add(item21);
        order1.getOrderItems().add(item31);
        
        DistributorOrder order2 = new DistributorOrder(1, 1, date);
        DistributorOrderItem item12 = new DistributorOrderItem(1, 5);
        DistributorOrderItem item22 = new DistributorOrderItem(2, 5);
        DistributorOrderItem item32 = new DistributorOrderItem(3, 5);

        order2.getOrderItems().add(item12);
        order2.getOrderItems().add(item22);
        order2.getOrderItems().add(item32);
        
        orders.add(order1);
        orders.add(order2);

        return orders;
    }
    
    public static void insertOrders() throws Exception {
        for (DistributorOrder order : orders) {
//            DistributorManager.createOrder(order);
        }
    }
}
