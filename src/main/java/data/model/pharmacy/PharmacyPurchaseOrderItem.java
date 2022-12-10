package data.model.pharmacy;

import data.model.common.Drug;


public class PharmacyPurchaseOrderItem {
    private final Drug drug;
    private final float selling_price;
    private final int quantity;

    public PharmacyPurchaseOrderItem(Drug drug, int quantity, float selling_price) {
        this.drug = drug;
        this.quantity = quantity;
        this.selling_price = selling_price;
    }

    public Drug getDrug() {
        return drug;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public float getSellingPrice() {
        return selling_price;
    }
}
