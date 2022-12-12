package main;

import db.PharmacyManager;
import email.SendEmail;
import java.sql.ResultSet;
import ui.manager.UIManager;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Welcome to Pharma Inventory Management");
//            UIManager.init();
            ResultSet rs = PharmacyManager.fetchAllStoreManagers(5);
            rs.next();
            System.out.println(rs.getString("person_name"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
