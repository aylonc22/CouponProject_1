package dao;

import beans.Company;
import cls.ConnectionPool;

import java.util.List;

public class CompaniesDBDAO implements CompaniesDAO{
    //TODO ask zeev about connectionpool as a var in the daoes instead of implementing it in each method as he prefered
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
