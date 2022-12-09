  package data.model.pharmacy;

import data.model.common.Date;


public class PharmacyOrderItem {
    private final int itemId;
    private final int quantity;

    public PharmacyOrderItem(int itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }
}
