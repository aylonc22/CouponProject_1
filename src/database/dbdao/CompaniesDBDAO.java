package database.dbdao;

//region Imports
import beans.Client;
import beans.Company;
import database.sql.DBmanager;
import database.sql.DButils;
import database.sql.commands.General;
import database.dao.CompaniesDAO;
import database.sql.commands.Companies;

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

        ResultSet resultSet = DButils.runQueryForResult(General.GET_CLIENT_IN_TABLE(DBmanager.SQL_COMPANIES),params);
        while (resultSet.next()){
            return resultSetToCompany(resultSet);
        }
        return null;
    }

    @Override
    public void addCompany(Company company) {
        Map<Integer, Object> params = companyToParams(company);
        if(DButils.runQuery(Companies.ADD_COMPANY,params))
            System.out.println("Company added\n" + company);
        else
            System.out.println("Company wasn't added");
    }

    @Override
    public void updateCompany(Company company) {
        Map<Integer, Object> params = companyToParams(company);
        // adding id in order to update directly from id
        params.put(params.size()+1,company.getId());
        if(DButils.runQuery(Companies.UPDATE_COMPANY,params))
            System.out.println("Company updated\n" + company);
        else
            System.out.println("Company wasn't updated");
    }

    @Override
    public void deleteCompany(int companyID) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,companyID);
        if(DButils.runQuery(Companies.DELETE_COMPANY,params))
            System.out.println("Company deleted");
        else
            System.out.println("Company wasn't deleted");
    }

    @Override
    public List<Company> getAllCompanies() throws SQLException {
        ResultSet resultSet = DButils.runQueryForResult(Companies.GET_ALL_COMPANY);
        List<Company> companies = new ArrayList<>();
        while(resultSet.next())
        {
            companies.add(resultSetToCompany(resultSet));
        }
        return companies;
    }

    @Override
    public Company getOneCompany(int companyID) throws SQLException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,companyID);
        ResultSet resultSet = DButils.runQueryForResult(Companies.GET_ONE_COMPANY,params);
        while (resultSet.next()) {
            return resultSetToCompany(resultSet);
        }
        return null;
    }


    @Override
    public Map<Integer, Object> companyToParams(Company company) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,company.getName());
        params.put(2,company.getEmail());
        params.put(3,company.getPassword());
        return params;
    }
    @Override
    public Company resultSetToCompany(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String email = resultSet.getString(3);
        String password = resultSet.getString(4);
        //TODO eventually ill need to sync coupons
        return new Company(id,name,email,password,new ArrayList<>());
    }
}
