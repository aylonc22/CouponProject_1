package dao;

import beans.Company;
import cls.sql.ConnectionPool;

import java.util.List;

public class CompaniesDBDAO implements CompaniesDAO{
private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    @Override
    public boolean isCompanyExists(String email, String password) {
        return false;
    }

    @Override
    public void addCompany(Company company) {

    }

    @Override
    public void updateCompany(Company company) {

    }

    @Override
    public void deleteCompany(int companyID) {

    }

    @Override
    public List<Company> getAllCompanies() {
        return null;
    }

    @Override
    public Company getOneCompany(int companyID) {
        return null;
    }
}
