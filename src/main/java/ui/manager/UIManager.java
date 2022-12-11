package ui.manager;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import ui.common.CompanyLoginPanel;
import ui.pharmacy.*;
import ui.common.MainPagePanel;
import ui.manufacturer.ManufacturerAdministratorPanel;
import ui.common.CompanyManagerPanel;
import ui.common.CompanyRegisterationPanel;

public abstract class UIManager {
    private final static MainFrame frame = new MainFrame();
    private static PharmacyAdministratorPanel pharmaAdmPanel;
    private static MainPagePanel mainPagePanel;
    private static PharmacyManagerPanel pharmaManagerPanel;
    private static CompanyLoginPanel companyLoginPanel;
    private static  ManufacturerAdministratorPanel manuAdministratorPanel;
    private static CompanyManagerPanel companyManagerPanel;
    private static CompanyRegisterationPanel companyRegPanel;
 
    
    public static void init() {
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        mainPagePanel = new MainPagePanel();
        removeAndAddPanel(mainPagePanel);
    }
    
    public static void AddpharmacyAdminPanel() {
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        pharmaAdmPanel = new PharmacyAdministratorPanel();
        removeAndAddPanel(pharmaAdmPanel);
    }
    
    public static void AddpharmacyManagerPanel() 
        {
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        pharmaManagerPanel = new PharmacyManagerPanel();
        removeAndAddPanel(pharmaManagerPanel);
    }
    
    public static void AddCompanyLoginPanel(String companyType) 
        {
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        companyLoginPanel = new CompanyLoginPanel(companyType);
        removeAndAddPanel(companyLoginPanel);
    }
    
      public static void AddManuAdminPanel() 
        {
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        manuAdministratorPanel = new ManufacturerAdministratorPanel();
        removeAndAddPanel(manuAdministratorPanel);
    }
      
      public static void AddCompanyManagerPanel(String companyType) 
        {
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        companyManagerPanel = new CompanyManagerPanel(companyType);
        removeAndAddPanel(companyManagerPanel);
    }
      public static void AddCompanyRegPanel(String companyType){
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        companyRegPanel = new CompanyRegisterationPanel(companyType);
        removeAndAddPanel(companyRegPanel);  
      }
      
     
    
    
    
    private static void removeAndAddPanel(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.add(panel);
        frame.repaint();
        frame.revalidate();
    }
}
