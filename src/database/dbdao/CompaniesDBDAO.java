package database.dbdao;

//region Imports
import beans.Client;
import beans.Company;
import beans.QueryResult;
import database.sql.DBmanager;
import database.sql.DButils;
import database.sql.SQLExceptionErrorCodes;
import database.sql.commands.General;
import database.dao.CompaniesDAO;
import database.sql.commands.Companies;
import exception.CouponSystemException;
import exception.ErrorMsg;

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
    public int getClientID(String email, String password) throws SQLException, CouponSystemException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,email);
        params.put(2,password);
        ResultSet resultSet = DButils.runQueryForResult(General.GET_CLIENT_ID_IN_TABLE(DBmanager.SQL_COMPANIES),params);
        while (resultSet.next()){
        return resultSet.getInt(1);
        }
        throw new CouponSystemException(ErrorMsg.COMPANY_NOT_FOUND);
    }

    @Override
    public void addCompany(Company company) throws CouponSystemException {
        Map<Integer, Object> params = DBDAOUtils.companyToParams(company);
        QueryResult queryResult = DButils.runQuery(Companies.ADD_COMPANY,params);
        if(queryResult.isResult()) {
            System.out.println("Company added\n" + company);
        }
        else {
            throw new CouponSystemException(ErrorMsg.SQL_DUPLICATE);
        }
    }

    @Override
    public void updateCompany(Company company) throws CouponSystemException {
        Map<Integer, Object> params = DBDAOUtils.companyToParams(company);
        // adding id in order to update directly from id
        params.put(params.size()+1,company.getId());
        QueryResult queryResult = DButils.runQuery(Companies.UPDATE_COMPANY,params);
        if(queryResult.isResult()) {
            System.out.println("Company updated\n" + company);
        }
        else {
            if(queryResult.getExceptionID() == SQLExceptionErrorCodes.DUPLICATE_KEY) {
                throw new CouponSystemException(ErrorMsg.SQL_DUPLICATE);
            }
            else
            {
                throw new CouponSystemException(ErrorMsg.COMPANY_NOT_FOUND);
            }
        }
    }

    @Override
    public void deleteCompany(int companyID) throws CouponSystemException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,companyID);
        QueryResult queryResult = DButils.runQuery(Companies.DELETE_COMPANY,params);
        if(queryResult.isResult()) {
            System.out.println("Company deleted");
        }
        else {
            throw new CouponSystemException(ErrorMsg.COMPANY_NOT_FOUND);
        }
    }

    @Override
    public List<Company> getAllCompanies() throws SQLException {
        ResultSet resultSet = DButils.runQueryForResult(Companies.GET_ALL_COMPANY);
        List<Company> companies = new ArrayList<>();
        while(resultSet.next())
        {
            Map<Integer, Object> params = new HashMap<>();
            params.put(1,resultSet.getString(3));
            params.put(2,resultSet.getString(4));

            ResultSet resultSetForSpecificCompany = DButils.runQueryForResult(Companies.GET_COMPANY_WITH_COUPONS,params);
            Company company = DBDAOUtils.handleBuildCompanyFromResultSet(resultSetForSpecificCompany,params);
            if(company != null)
                companies.add(company);
        }
        return companies;
    }

    @Override
    public Company getOneCompany(int companyID) throws SQLException, CouponSystemException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,companyID);
        ResultSet resultSet = DButils.runQueryForResult(Companies.GET_ONE_COMPANY,params);

        params.clear();
        while (resultSet.next())
        {
            params.put(1,resultSet.getString(3));
            params.put(2,resultSet.getString(4));

            ResultSet resultSetForSpecificCompany = DButils.runQueryForResult(Companies.GET_COMPANY_WITH_COUPONS,params);
            Company company = DBDAOUtils.handleBuildCompanyFromResultSet(resultSetForSpecificCompany,params);
            if(company!= null){
                return  company;
            }
        }
        throw new CouponSystemException(ErrorMsg.COMPANY_NOT_FOUND);
    }

}
