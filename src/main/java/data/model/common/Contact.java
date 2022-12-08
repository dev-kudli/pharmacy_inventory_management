package data.model.common;

public class Contact {
    public String email;
    public String phone;
    public Location location;
    
    public Contact() {
        this.location = new Location();
    }
}
