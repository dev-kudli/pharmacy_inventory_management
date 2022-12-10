
package helper.ui;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public abstract class UiDesignFunctions {
 
        
    public static void AlignTableContents(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.LEFT );
        for (int columnIndex = 0; columnIndex < table.getModel().getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(leftRenderer);
        }
        System.out.println("Table Alignment done");
    
    }
    
    public static void SetButtonBg(Color globalColor, JButton button){
        button.setBackground(globalColor);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }
    
        public static void SetButtonBgGreen(JButton button){
        Color globalColor = new Color(129, 211, 129);
        button.setBackground(globalColor);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }
        
        public static void SetButtonBgRed(JButton button){
        Color globalColor = new Color(227, 66, 52);
        button.setBackground(globalColor);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }
        
        public static void searchEmployeeDetails(String keyword,JTable table){
        DefaultTableModel tableSearch = (DefaultTableModel)table.getModel();
        //DefaultTableModel tableEdit = (DefaultTableModel)jTableEdit.getModel();
        
        TableRowSorter<DefaultTableModel> sortertableSearch = new TableRowSorter<>(tableSearch);
        //TableRowSorter<DefaultTableModel> sortertableEdit = new TableRowSorter<>(tableEdit);
        
        table.setRowSorter(sortertableSearch);
        //jTableEdit.setRowSorter(sortertableEdit);
        

        sortertableSearch.setRowFilter(RowFilter.regexFilter("(?i)"+keyword));
        //sortertableEdit.setRowFilter(RowFilter.regexFilter("(?i)"+keyword));

}
}
