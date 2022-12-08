/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model.person;
import data.model.common.Contact;
import data.model.common.Date;
import db.PersonManager;

public class Person {
    private String username;
    private String personName;
    private String personRole;
    private Date personDob;
    private String personGender;
    private Contact personContact;
    private String password;
     
    public Person(String username, String personName, String password) {
        this.username = username;
        this.personName = personName;
        this.password = password;
        this.personContact = new Contact();
    }
    
    public String getUsername() {
        return username;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonRole() {
        return personRole;
    }

    public void setPersonType(String personType) {
        this.personRole = personType;
    }

    public Date getPersonDob() {
        return personDob;
    }

    public void setPersonDob(Date personDob) {
        this.personDob = personDob;
    }

    public String getPersonGender() {
        return personGender;
    }

    public void setPersonGender(String personGender) {
        this.personGender = personGender;
    }

    public Contact getPersonContact() {
        return personContact;
    }

    public String getPassword() {
        return password;
    }
    
    public boolean save() throws Exception {
        return PersonManager.createUser(this);
    }
}
