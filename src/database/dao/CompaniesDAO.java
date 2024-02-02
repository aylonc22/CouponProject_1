package database.dao;

//region Imports
import beans.Client;
import beans.Company;
import exception.ObjectNotFoundException;
import exception.SQLDuplicateUniqueKeyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
//endregion

public interface CompaniesDAO {
    //region Core Methods
      boolean isCompanyExists(String email, String password) throws SQLException;
      Client getClient(String email, String password) throws SQLException;
     void addCompany(Company company) throws SQLDuplicateUniqueKeyException;
     void updateCompany(Company company) throws SQLDuplicateUniqueKeyException, ObjectNotFoundException;
     void deleteCompany(int companyID) throws ObjectNotFoundException;
     List<Company> getAllCompanies() throws SQLException;
     Company getOneCompany(int companyID) throws SQLException, ObjectNotFoundException;
    //endregion

}
