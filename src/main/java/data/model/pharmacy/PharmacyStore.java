package data.model.pharmacy;

import data.model.common.Location;

public class PharmacyStore {
    private final String storeName;
    private final int pharmacyId;
    public Location location;

    public PharmacyStore(String storeName, int pharmacyId, Location location) {
        this.storeName = storeName;
        this.pharmacyId = pharmacyId;
        this.location = location;
    }
    
        public PharmacyStore(String storeName, int pharmacyId) {
        this.storeName = storeName;
        this.pharmacyId = pharmacyId;
     
    }

    public String getStoreName() {
        return storeName;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public Location getLocation() {
        return location;
    }
}
