package database.dbdao;

//region Imports
import beans.Client;
import beans.Company;
import beans.QueryResult;
import database.sql.DBmanager;
import database.sql.DButils;
import database.sql.SQLExceptionErrorCodes;
import database.sql.commands.Categories;
import database.sql.commands.General;
import database.dao.CompaniesDAO;
import database.sql.commands.Companies;
import exception.ObjectNotFoundException;
import exception.SQLDuplicateUniqueKeyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//endregion

public class CompaniesDBDAO implements CompaniesDAO {
    @Override
    public boolean isCompanyExists(String email, String password) throws SQLException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,email);
        params.put(2,password);

        ResultSet resultSet = DButils.runQueryForResult(General.IS_EXISTS_IN_TABLE(DBmanager.SQL_COMPANIES),params);
        while (resultSet.next()){
            return resultSet.getInt(1) == 1;
        }
        return false;
    }

    @Override
    public Client getClient(String email, String password) throws SQLException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,email);
        params.put(2,password);
        Company company = null;
        ResultSet resultSet = DButils.runQueryForResult(Companies.GET_COMPANY_WITH_COUPONS,params);
        //If there are any coupons
        while (resultSet.next()){
            if (company==null) {
                company = DBDAOUtils.resultSetToCompany(resultSet);
                company.getCoupons().add(DBDAOUtils.resultSetToCouponOfCompanies(resultSet));
            }
            else{
                company.getCoupons().add(DBDAOUtils.resultSetToCouponOfCompanies(resultSet));
            }

        }
        // If there were no coupons the query will return nothing then we need another query to
        // get at least the basic details of the company
         resultSet = DButils.runQueryForResult(Companies.GET_COMPANY,params);
        if(company == null) {
            while (resultSet.next()) {
                company = DBDAOUtils.resultSetToCompany(resultSet);
            }
        }
        return company;
    }

    @Override
    public void addCompany(Company company) throws SQLDuplicateUniqueKeyException {
        Map<Integer, Object> params = DBDAOUtils.companyToParams(company);
        QueryResult queryResult = DButils.runQuery(Companies.ADD_COMPANY,params);
        if(queryResult.isResult()) {
            System.out.println("Company added\n" + company);
        }
        else {
            throw new SQLDuplicateUniqueKeyException(SQLDuplicateUniqueKeyException.tables.COMPANY);
        }
    }

    @Override
    public void updateCompany(Company company) throws SQLDuplicateUniqueKeyException, ObjectNotFoundException {
        Map<Integer, Object> params = DBDAOUtils.companyToParams(company);
        // adding id in order to update directly from id
        params.put(params.size()+1,company.getId());
        QueryResult queryResult = DButils.runQuery(Companies.UPDATE_COMPANY,params);
        if(queryResult.isResult()) {
            System.out.println("Company updated\n" + company);
        }
        else {
            if(queryResult.getExceptionID() == SQLExceptionErrorCodes.DUPLICATE_KEY) {
                throw new SQLDuplicateUniqueKeyException(SQLDuplicateUniqueKeyException.tables.COMPANY);
            }
            else
            {
                throw new ObjectNotFoundException(company.getId(),"Company");
            }
        }
    }

    @Override
    public void deleteCompany(int companyID) throws ObjectNotFoundException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,companyID);
        QueryResult queryResult = DButils.runQuery(Companies.DELETE_COMPANY,params);
        if(queryResult.isResult()) {
            System.out.println("Company deleted");
        }
        else {
            throw new ObjectNotFoundException(companyID, "Company");
        }
    }

    @Override
    public List<Company> getAllCompanies() throws SQLException {
        ResultSet resultSet = DButils.runQueryForResult(Companies.GET_ALL_COMPANY);
        List<Company> companies = new ArrayList<>();
        while(resultSet.next())
        {
            companies.add(DBDAOUtils.resultSetToCompany(resultSet));
        }
        return companies;
    }

    @Override
    public Company getOneCompany(int companyID) throws SQLException, ObjectNotFoundException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,companyID);
        ResultSet resultSet = DButils.runQueryForResult(Companies.GET_ONE_COMPANY,params);
        while (resultSet.next()) {
            return DBDAOUtils.resultSetToCompany(resultSet);
        }
       throw new ObjectNotFoundException(companyID,"Company");
    }

}
