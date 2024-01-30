package database.dao;

import beans.Client;
import beans.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CustomersDAO {
    //region Core Methods
    public boolean isCustomerExists(String email, String password) throws SQLException;
    public Client getClient(String email, String password) throws SQLException;
    public void addCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(int customerID);
    public List<Customer> getAllCustomers() throws SQLException;
    public Customer getOneCustomer(int customerID) throws SQLException;
    //endregion

    //region Auxiliary Methods
    public Map<Integer,Object> customerToParams(Customer customer);
    public Customer resultSetToCustomer(ResultSet resultSet) throws SQLException;
    //endregion
}
