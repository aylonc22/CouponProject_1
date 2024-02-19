package database.dbdao;

//region Imports
import beans.Client;
import beans.Customer;
import beans.QueryResult;
import database.sql.DBmanager;
import database.sql.DButils;
import database.sql.SQLExceptionErrorCodes;
import database.sql.commands.General;
import database.dao.CustomersDAO;
import database.sql.commands.Customers;
import exception.CouponSystemException;
import exception.ErrorMsg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//endregion

public class CustomerDBDAO implements CustomersDAO {

    @Override
    public boolean isCustomerExists(String email, String password) throws SQLException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,email);
        params.put(2,password);

        ResultSet resultSet = DButils.runQueryForResult(General.IS_EXISTS_IN_TABLE(DBmanager.SQL_CUSTOMERS),params);

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

        ResultSet resultSet = DButils.runQueryForResult(General.GET_CLIENT_IN_TABLE(DBmanager.SQL_CUSTOMERS),params);
        while (resultSet.next()){
            Client customer = DBDAOUtils.resultSetToCustomer(resultSet);
            customer.getCoupons().addAll(new CouponDBDAO().getAllCouponsOfCustomer(customer.getId()));
                return customer;
        }
        return null;
    }

    @Override
    public void addCustomer(Customer customer) throws CouponSystemException {
        Map<Integer, Object> params = DBDAOUtils.customerToParams(customer);
        QueryResult queryResult = DButils.runQuery(Customers.ADD_CUSTOMER,params);
        if(queryResult.isResult()) {
            System.out.println("Customer added\n" + customer);
        }
        else {
           throw new CouponSystemException(ErrorMsg.SQL_DUPLICATE);
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws CouponSystemException {
        Map<Integer, Object> params = DBDAOUtils.customerToParams(customer);
        // adding id in order to update directly from id
        params.put(params.size()+1,customer.getId());
        QueryResult queryResult = DButils.runQuery(Customers.UPDATE_CUSTOMER,params);
        if(queryResult.isResult()) {
            System.out.println("Customer updated\n" + customer);
        }
        else {
           if(queryResult.getExceptionID() == SQLExceptionErrorCodes.DUPLICATE_KEY){
               throw new CouponSystemException(ErrorMsg.SQL_DUPLICATE);
           }
           else {
               throw  new CouponSystemException(ErrorMsg.Customer_NOT_FOUND);
           }
        }
    }

    @Override
    public void deleteCustomer(int customerID) throws CouponSystemException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,customerID);
        QueryResult queryResult = DButils.runQuery(Customers.DELETE_CUSTOMER,params);
        if(queryResult.isResult()) {
            System.out.println("Customer deleted");
        }
        else {
            throw new CouponSystemException(ErrorMsg.Customer_NOT_FOUND);
        }
    }

    @Override
    public List<Customer> getAllCustomers() throws SQLException {
        ResultSet resultSet = DButils.runQueryForResult(Customers.GET_ALL_CUSTOMERS);
        List<Customer> customers = new ArrayList<>();
        while(resultSet.next())
        {
            Customer customer = DBDAOUtils.resultSetToCustomer(resultSet);
            customer.getCoupons().addAll(new CouponDBDAO().getAllCouponsOfCustomer(customer.getId()));
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public Customer getOneCustomer(int customerID) throws SQLException, CouponSystemException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,customerID);
        ResultSet resultSet = DButils.runQueryForResult(Customers.GET_ONE_CUSTOMER,params);
        while (resultSet.next()) {
            Customer customer = DBDAOUtils.resultSetToCustomer(resultSet);
            customer.getCoupons().addAll(new CouponDBDAO().getAllCouponsOfCustomer(customer.getId()));
            return customer;
        }
        throw new CouponSystemException(ErrorMsg.Customer_NOT_FOUND);
    }
}
