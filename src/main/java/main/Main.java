package main;

import ui.manager.UIManager;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Welcome to Pharma Inventory Management");
            UIManager.init();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
