package data.model.pharmacy;

import data.model.common.Drug;


public class PharmacyPurchaseOrderItem {
    private final Drug drug;
    private final int quantity;

    public PharmacyPurchaseOrderItem(Drug drug, int quantity) {
        this.drug = drug;
        this.quantity = quantity;
    }

    public Drug getDrug() {
        return drug;
    }

    public int getQuantity() {
        return quantity;
    }
}
