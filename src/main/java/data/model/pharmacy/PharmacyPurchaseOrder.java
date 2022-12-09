package data.model.pharmacy;
import data.model.common.Date;
import java.util.ArrayList;
import java.util.List;

public class PharmacyPurchaseOrder {
    private final int pharmacyCompanyId;
    private final int manufactureId;
    private final Date purchaseOrderDate;
    private String orderStatus;
    private final List<PharmacyOrderItem> orderItems = new ArrayList<>();

    public PharmacyPurchaseOrder(int pharmacyCompanyId, int manufactureId, Date purchaseOrderDate) {
        this.pharmacyCompanyId = pharmacyCompanyId;
        this.manufactureId = manufactureId;
        this.purchaseOrderDate = purchaseOrderDate;
    }
    
    public int getOrderId() {
        return orderId;
    }
    
    public void setOrderId(int id) {
        this.orderId = id;
    }
    
    public String getOrderStatus() {
        return orderStatus;
    }
    
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPharmacyCompanyId() {
        return pharmacyCompanyId;
    }

    public int getPharmacymanufactureId() {
        return manufactureId;
    }

    public Date getPurchaseOrderDate() {
        return purchaseOrderDate;
    }
    
    public List<PharmacyOrderItem> getOrderItems() {
        return orderItems;
    }
}
