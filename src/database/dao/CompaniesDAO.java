package database.dao;

//region Imports
import beans.Client;
import beans.Company;
import exception.CouponSystemException;

import java.sql.SQLException;
import java.util.List;
//endregion

public interface CompaniesDAO {
    //region Core Methods
      boolean isCompanyExists(String email, String password) throws SQLException;
      int getClientID(String email, String password) throws SQLException, CouponSystemException;
     void addCompany(Company company) throws CouponSystemException;
     void updateCompany(Company company) throws CouponSystemException;
     void deleteCompany(int companyID) throws CouponSystemException;
     List<Company> getAllCompanies() throws SQLException;
     Company getOneCompany(int companyID) throws SQLException, CouponSystemException;
    //endregion

}
