package database.dao;

import beans.Client;
import beans.Customer;
import exception.CouponSystemException;

import java.sql.SQLException;
import java.util.List;

public interface CustomersDAO {
    //region Core Methods
    public boolean isCustomerExists(String email, String password) throws SQLException;
    public int getClientID(String email, String password) throws SQLException, CouponSystemException;
    public void addCustomer(Customer customer) throws CouponSystemException;
    public void updateCustomer(Customer customer) throws CouponSystemException;
    public void deleteCustomer(int customerID) throws CouponSystemException;
    public List<Customer> getAllCustomers() throws SQLException;
    public Customer getOneCustomer(int customerID) throws SQLException, CouponSystemException;
    //endregion
}
