package db;

import data.model.common.Company;
import static db.DistributorManager.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CompanyManager {
    public static java.sql.Connection con = Connection.getConnection();
        public static boolean createCompany(Company company) throws Exception {
        boolean isCreated = true;
        try {
            String query1 = "INSERT INTO company(registered_date, company_name, company_type)"
                            + "values (?, ?, ?)";
            PreparedStatement preparedStmt1 = con.prepareStatement(query1);
            preparedStmt1.setString (1, company.getRegisteredDate().getFormattedDate());
            preparedStmt1.setString (2, company.getCompanyName());
            preparedStmt1.setString (3, company.getCompanyType());
            preparedStmt1.execute();
            return isCreated;
        } catch (SQLException e) {
            throw e;
        }
    }
        
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
