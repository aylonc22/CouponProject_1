package database.dbdao;

//region Imports
import beans.Client;
import beans.Customer;
import database.sql.DBmanager;
import database.sql.DButils;
import database.sql.commands.General;
import database.dao.CustomersDAO;
import database.sql.commands.Customers;

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
            return resultSetToCustomer(resultSet);
        }
        return null;
    }

    @Override
    public void addCustomer(Customer customer) {
        Map<Integer, Object> params = customerToParams(customer);
        if(DButils.runQuery(Customers.ADD_CUSTOMER,params))
            System.out.println("Customer added\n" + customer);
        else
            System.out.println("Customer wasn't added");
    }

    @Override
    public void updateCustomer(Customer customer) {
        Map<Integer, Object> params = customerToParams(customer);
        // adding id in order to update directly from id
        params.put(params.size()+1,customer.getId());
        if(DButils.runQuery(Customers.UPDATE_CUSTOMER,params))
            System.out.println("Customer updated\n" + customer);
        else
            System.out.println("Customer wasn't updated");
    }

    @Override
    public void deleteCustomer(int customerID) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,customerID);
        if(DButils.runQuery(Customers.DELETE_CUSTOMER,params))
            System.out.println("Customer deleted");
        else
            System.out.println("Customer wasn't deleted");
    }

    @Override
    public List<Customer> getAllCustomers() throws SQLException {
        ResultSet resultSet = DButils.runQueryForResult(Customers.GET_ALL_CUSTOMERS);
        List<Customer> customers = new ArrayList<>();
        while(resultSet.next())
        {
            customers.add(resultSetToCustomer(resultSet));
        }
        return customers;
    }

    @Override
    public Customer getOneCustomer(int customerID) throws SQLException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,customerID);
        ResultSet resultSet = DButils.runQueryForResult(Customers.GET_ONE_CUSTOMERS,params);
        while (resultSet.next()) {
            return resultSetToCustomer(resultSet);
        }
        return null;
    }

    @Override
    public Map<Integer, Object> customerToParams(Customer customer) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,customer.getFirstName());
        params.put(2,customer.getLastName());
        params.put(3,customer.getEmail());
        params.put(4,customer.getPassword());
        return params;
    }

    @Override
    public Customer resultSetToCustomer(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String firstName = resultSet.getString(2);
        String lastName = resultSet.getString(3);
        String email = resultSet.getString(4);
        String password = resultSet.getString(5);
        //TODO eventually ill need to sync coupons
        return new Customer(id,firstName,lastName,email,password,new ArrayList<>());
    }
}
