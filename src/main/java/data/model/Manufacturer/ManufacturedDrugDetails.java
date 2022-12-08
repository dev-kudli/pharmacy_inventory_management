/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model.Manufacturer;

/**
 *
 * @author alank
 */
public class ManufacturedDrugDetails {
    private int companyId;
    private String drugName;
    private int drugQuantity;
    private int drugType;
    private String expirationDate;
    private String manufacturedDate;
    private boolean drugAvailability;
    private double drugprice;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public int getDrugQuantity() {
        return drugQuantity;
    }

    public void setDrugQuantity(int drugQuantity) {
        this.drugQuantity = drugQuantity;
    }

    public int getDrugType() {
        return drugType;
    }

    public void setDrugType(int drugType) {
        this.drugType = drugType;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(String manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public boolean isDrugAvailability() {
        return drugAvailability;
    }

    public void setDrugAvailability(boolean drugAvailability) {
        this.drugAvailability = drugAvailability;
    }

    public double getDrugprice() {
        return drugprice;
    }

    public void setDrugprice(double drugprice) {
        this.drugprice = drugprice;
    }
    
    
    
}
