package dao;

//region Imports
import beans.Company;
import beans.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
//endregion

public interface CompaniesDAO {
    //region Core Methods
    public  boolean isCompanyExists(String email,String password) throws SQLException;
    public void addCompany(Company company);
    public void updateCompany(Company company);
    public void deleteCompany(int companyID);
    public List<Company> getAllCompanies() throws SQLException;
    public Company getOneCompany(int companyID) throws SQLException;
    //endregion
    //region Auxiliary Methods
    public Map<Integer,Object> companyToParams(Company company);
    public Company resultSetToCompany(ResultSet resultSet) throws SQLException;
    //endregion

}
