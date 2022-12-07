/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model.pharmacy;

/**
 *
 * @author shreyajaiswal
 */
public class PharmacyPurchaseOrderItem {
    private int pharmacyPurchaseOrderId;
    private int pharmacyDrugId;
    private int quantity;
    private int unitPrice;

    public int getPharmacyPurchaseOrderId() {
        return pharmacyPurchaseOrderId;
    }

    public void setPharmacyPurchaseOrderId(int pharmacyPurchaseOrderId) {
        this.pharmacyPurchaseOrderId = pharmacyPurchaseOrderId;
    }

    public int getPharmacyDrugId() {
        return pharmacyDrugId;
    }

    public void setPharmacyDrugId(int pharmacyDrugId) {
        this.pharmacyDrugId = pharmacyDrugId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    
    
}
