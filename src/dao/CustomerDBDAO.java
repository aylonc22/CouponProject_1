package dao;

import beans.Customer;
import cls.ConnectionPool;
import java.util.List;

public class CustomerDBDAO implements CustomersDAO{
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    @Override
    public boolean isCustomerExists(String email, String password) {
        return false;
    }

    @Override
    public void addCustomer(Customer Customer) {

    }

    @Override
    public void updateCustomer(Customer Customer) {

    }

    @Override
    public void deleteCustomer(int CustomerID) {

    }

    @Override
    public List<Customer> getAllCompanies() {
        return null;
    }

    @Override
    public Customer getOneCustomer(int CustomerID) {
        return null;
    }
}
