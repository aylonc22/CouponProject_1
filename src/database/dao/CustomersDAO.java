package database.dao;

import beans.Client;
import beans.Customer;
import exception.ObjectNotFoundException;
import exception.SQLDuplicateUniqueKeyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CustomersDAO {
    //region Core Methods
    public boolean isCustomerExists(String email, String password) throws SQLException;
    public Client getClient(String email, String password) throws SQLException;
    public void addCustomer(Customer customer) throws SQLDuplicateUniqueKeyException;
    public void updateCustomer(Customer customer) throws SQLDuplicateUniqueKeyException, ObjectNotFoundException;
    public void deleteCustomer(int customerID) throws ObjectNotFoundException;
    public List<Customer> getAllCustomers() throws SQLException;
    public Customer getOneCustomer(int customerID) throws SQLException, ObjectNotFoundException;
    //endregion
}
