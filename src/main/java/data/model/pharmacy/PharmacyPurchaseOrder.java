/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model.pharmacy;
import data.model.common.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shreyajaiswal
 */
public class PharmacyPurchaseOrder {
    private final int pharmacyCompanyId;
    private final int pharmacydistributorId;
    private final Date purchaseOrderDate;
    private final List<PharmacyOrderItem> orderItems = new ArrayList<>();

    public PharmacyPurchaseOrder(int pharmacyCompanyId, int pharmacydistributorId, Date purchaseOrderDate) {
        this.pharmacyCompanyId = pharmacyCompanyId;
        this.pharmacydistributorId = pharmacydistributorId;
        this.purchaseOrderDate = purchaseOrderDate;
    }

    public int getPharmacyCompanyId() {
        return pharmacyCompanyId;
    }

    public int getPharmacydistributorId() {
        return pharmacydistributorId;
    }

    public Date getPurchaseOrderDate() {
        return purchaseOrderDate;
    }
    
    public List<PharmacyOrderItem> getOrderItems() {
        return orderItems;
    }
}
