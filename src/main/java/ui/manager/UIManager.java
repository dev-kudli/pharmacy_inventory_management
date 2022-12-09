package ui.manager;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import javax.swing.JPanel;
import ui.pharmacy.*;

public abstract class UIManager {
    private final static MainFrame frame = new MainFrame();
    private static PharmacyAdministratorPanel pharmaAdmPanel;
    
    public static void init() {
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        pharmaAdmPanel = new PharmacyAdministratorPanel();
        removeAndAddPanel(pharmaAdmPanel);
    }
    
    private static void removeAndAddPanel(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.add(panel);
        frame.repaint();
        frame.revalidate();
    }
}
