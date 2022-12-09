package data.model.pharmacy;

public class PharmacyPurchaseOrderItem {
    public int drugId;
    public int quantity;
    public float unitPrice;

    public PharmacyPurchaseOrderItem(int drugId, int quantity, float unitPrice) {
        this.drugId = drugId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }   
}
