package database.dao;

//region Imports
import beans.Client;
import beans.Company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
//endregion

public interface CompaniesDAO {
    //region Core Methods
      boolean isCompanyExists(String email, String password) throws SQLException;
      Client getClient(String email, String password) throws SQLException;
     void addCompany(Company company);
     void updateCompany(Company company);
     void deleteCompany(int companyID);
     List<Company> getAllCompanies() throws SQLException;
     Company getOneCompany(int companyID) throws SQLException;
    //endregion
    //region Auxiliary Methods
     Map<Integer,Object> companyToParams(Company company);
     Company resultSetToCompany(ResultSet resultSet) throws SQLException;
    //endregion

}
