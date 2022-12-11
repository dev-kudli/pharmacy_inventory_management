package db;

import data.model.common.Company;
import helper.constant.CompanyTypes;
import helper.validation.Validation;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class CompanyManager {
    public static java.sql.Connection con = Connection.getConnection();
    /**
     * @param company - Company class
     * @param username - Username of owner
     * @return ResultSet if operation succeeds
     * @throws java.lang.Exception
     */
    public static boolean createCompany(Company company, String username) throws Exception {
        boolean isCreated = true;
        if (!Validation.isValidString(company.getCompanyName())) throw new Error("Invalid Company Name");
        try {
            String query1 = "INSERT INTO company(registered_date, company_name, company_type, company_owner)"
                            + "values (?, ?, ?, ?)";
            PreparedStatement preparedStmt1 = con.prepareStatement(query1);
            preparedStmt1.setString (1, company.getRegisteredDate().getFormattedDate());
            preparedStmt1.setString (2, company.getCompanyName());
            preparedStmt1.setString (3, company.getCompanyType());
            preparedStmt1.setString (4, username);
            preparedStmt1.execute();
            return isCreated;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    /**
     * @param companyId - Company ID
     * @param username - Username of a Person
     * @return ResultSet if operation succeeds
     * @throws java.lang.Exception
     */
    public static int assignCompanyOwner(int companyId, String username) throws Exception {
        try {
            String queryToAssignOwner = """
                UPDATE company
                SET company_owner=%s
                WHERE company_id=%s""";
            queryToAssignOwner = String.format(queryToAssignOwner, username, companyId);
            Statement stmt = con.createStatement();
            return stmt.executeUpdate(queryToAssignOwner);
        } catch (SQLException e) {
            throw e;
        }
    }
        
    /**
     * @param id - ID of Company
     * @return ResultSet if operation succeeds
     * @throws java.lang.Exception
     */
    public static boolean deleteCompany(int id) throws Exception {
        boolean isDeleted = true;
        try {
            String query = String.format("DELETE FROM company WHERE company_id=%s", id);
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.execute();
            return isDeleted;
        } catch (SQLException e) {
            throw e;
        }
    }
}
