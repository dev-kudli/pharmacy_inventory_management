package data.model.distributor;


public class DistributorOrderItem {
    private int itemId;
    private int quantity;

    public DistributorOrderItem(int itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
