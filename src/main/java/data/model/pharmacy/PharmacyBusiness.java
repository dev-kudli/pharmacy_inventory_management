/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model.pharmacy;

import java.util.ArrayList;

/**
 *
 * @author shreyajaiswal
 */
public class PharmacyBusiness {
    String name;
    
    public PharmacyBusiness(String n) {
        name = n;
//        masterorderlist = new MasterOrderList();
//        suppliers = new SupplierDirectory();
////        solutionoffercatalog = new SolutionOfferCatalog();
//        persondirectory = new PersonDirectory();
//        customerdirectory = new CustomerDirectory(this);
//        salespersondirectory = new SalesPersonDirectory(this);
//        useraccountdirectory = new UserAccountDirectory();
//        marketingpersondirectory = new MarketingPersonDirectory(this);
//        employeedirectory = new EmployeeDirectory(this);
//
//    }
//
//    public int getSalesVolume() {
//        return masterorderlist.getSalesVolume();
//
//    }
//
//    public PersonDirectory getPersonDirectory() {
//        return persondirectory;
//    }
//
//    public UserAccountDirectory getUserAccountDirectory() {
//        return useraccountdirectory;
//    }
//    public MarketingPersonDirectory getMarketingPersonDirectory() {
//        return marketingpersondirectory;
//    }
//
    public CompanyDirectory getCompanyTable() {
        return companyTable;
    }

//    public ProductsReport getSupplierPerformanceReport(String n) {
//        Supplier supplier = suppliers.findSupplier(n);
//        if (supplier == null) {
//            return null;
//        }
//        return supplier.prepareProductsReport();
//
//    }
//
//    public ArrayList<ProductSummary> getSupplierProductsAlwaysAboveTarget(String n) {
//
//        ProductsReport productsreport = getSupplierPerformanceReport(n);
//        return productsreport.getProductsAlwaysAboveTarget();
//
//    }
//
//    public int getHowManySupplierProductsAlwaysAboveTarget(String n) {
//        ProductsReport productsreport = getSupplierPerformanceReport(n); // see above
//        int i = productsreport.getProductsAlwaysAboveTarget().size(); //return size of the arraylist
//        return i;
//    }
//
//    public CustomerDirectory getCustomerDirectory() {
//        return customerdirectory;
//    }
//
//    public SalesPersonDirectory getSalesPersonDirectory() {
//        return salespersondirectory;
//    }
//
//    public MasterOrderList getMasterOrderList() {
//        return masterorderlist;
//    }
//        public EmployeeDirectory getEmployeeDirectory() {
//        return employeedirectory;
//    }

    
}
}