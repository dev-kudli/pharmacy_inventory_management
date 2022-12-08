package main;

import ui.frame.MainFrame;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Pharma Inventory Management");
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
        frame.showPharmacyAdminPanel();
    }
}
