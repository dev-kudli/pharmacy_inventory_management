package data.model.common;

public class Location {
    public String address;
    public String zipcode;
    public String city;

    
    public Location(String address, String zipcode, String city){
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
