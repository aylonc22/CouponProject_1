package dao;

import beans.Customer;
import java.util.List;

public interface CustomersDAO {
    public  boolean isCustomerExists(String email,String password);
    public void addCustomer(Customer Customer);
    public void updateCustomer(Customer Customer);
    public void deleteCustomer(int CustomerID);
    public List<Customer> getAllCompanies();
    public Customer getOneCustomer(int CustomerID);
}
