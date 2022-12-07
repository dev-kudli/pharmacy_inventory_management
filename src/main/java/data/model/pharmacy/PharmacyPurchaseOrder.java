/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model.pharmacy;

/**
 *
 * @author shreyajaiswal
 */
public class PharmacyPurchaseOrder {
    private int pharmacyCompanyId;
    private int pharmacydistributorId;
    private  String purchaseOrderDate;

    public int getPharmacyCompanyId() {
        return pharmacyCompanyId;
    }

    public void setPharmacyCompanyId(int pharmacyCompanyId) {
        this.pharmacyCompanyId = pharmacyCompanyId;
    }

    public int getPharmacydistributorId() {
        return pharmacydistributorId;
    }

    public void setPharmacydistributorId(int pharmacydistributorId) {
        this.pharmacydistributorId = pharmacydistributorId;
    }

    public String getPurchaseOrderDate() {
        return purchaseOrderDate;
    }

    public void setPurchaseOrderDate(String purchaseOrderDate) {
        this.purchaseOrderDate = purchaseOrderDate;
    }
    
    
    
}
