package data.model.distributor;

import data.model.common.*;
import java.util.ArrayList;
import java.util.List;

public class DistributorOrder {
    private final int distributorId;
    private final int manufacturerId;
    private final Date orderDate;
    private final List<DistributorOrderItem> orderItems;
    
    public DistributorOrder(int distributorId, int manufacturerId, Date date) {
        this.distributorId = distributorId;
        this.manufacturerId = manufacturerId;
        this.orderDate = date;
        this.orderItems = new ArrayList<>();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public int getDistributorId() {
        return distributorId;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public List<DistributorOrderItem> getOrderItems() {
        return orderItems;
    }
}
