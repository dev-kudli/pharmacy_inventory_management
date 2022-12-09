package data.model.Manufacturer;

import data.model.common.Drug;

public class ManufacturedDrugDetails {
    private final int manufacturerId;
    private final Drug drug;
    private final int drugQuantity;
    private final double drugCostPrice;
    private final double drugSellingPrice;

    public ManufacturedDrugDetails(int manufacturerId, int drugQuantity, double drugCostPrice, double drugSellingPrice, Drug drug) {
        this.manufacturerId = manufacturerId;
        this.drugQuantity = drugQuantity;
        this.drugCostPrice = drugCostPrice;
        this.drugSellingPrice = drugSellingPrice;
        this.drug = drug;
    }
    
    public int getManufacturerId() {
        return manufacturerId;
    }
    
    public Drug getDrug() {
        return drug;
    }
    
    public double getDrugCostPrice() {
        return drugCostPrice;
    }

    public int getDrugQuantity() {
        return drugQuantity;
    }

    public double getDrugCostprice() {
        return drugCostPrice;
    }

    public double getDrugSellingPrice() {
        return drugSellingPrice;
    }
}