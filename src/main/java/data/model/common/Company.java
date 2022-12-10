package data.model.common;

public class Company {
    
    private String companyName;
    private String companyType;
    private Date registeredDate;
    private Location location;
    
    public Company(String companyName, String companyType) {
        this.companyName = companyName;
        this.companyType = companyType;
    }

    public String getCompanyName() {
        return companyName;
    }
    
    public String getCompanyType() {
        return companyType;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
    
    public Location getLocation(Location location) {
        return location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
}
