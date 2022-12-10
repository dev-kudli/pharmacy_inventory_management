package data.model.common;

public class Drug {
    private final int drugId;
    private final String drugName;
    private int drugType;

    public Drug(int drugId, String drugName) {
        this.drugId = drugId;
        this.drugName = drugName;
    }
    public int getDrugId() {
        return drugId;
    }
    
    public String getDrugName() {
        return drugName;
    }

    public int getDrugType() {
        return drugType;
    }

    public void setDrugType(int drugType) {
        this.drugType = drugType;
    }
}