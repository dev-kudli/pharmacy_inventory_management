/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model.person;

import data.model.common.Contact;

/**
 *
 * @author shreyajaiswal
 */
public class Person {
     String id;
     private String personName;
     private String personType;
     private String personDob;
     private String personGender;
     private Contact personContact;
     private String username;
     private String password;
     
     public Person(String id) {

        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getPersonDob() {
        return personDob;
    }

    public void setPersonDob(String personDob) {
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

    public void setPersonContact(Contact personContact) {
        this.personContact = personContact;
    }
     

 

    public String getPersonId() {
        return id;
    }

    public boolean isMatch(String id) {
        if (getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    @Override
    public String toString() {
        return getPersonId();
    }
}
