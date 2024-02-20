package facade;

import beans.Client;
import beans.ClientType;
import beans.Company;
import beans.Customer;
import database.sql.DBmanager;
import exception.CouponSystemException;
import exception.ErrorMsg;

import java.sql.SQLException;
import java.util.List;

public class AdminFacade extends ClientFacade {
    //region Constructors
    public AdminFacade(String email,String password) throws CouponSystemException, SQLException {
        super(email,password);
    }
    //endregion

    //region Overrides
    @Override
    public int login(String email, String password) throws CouponSystemException, SQLException {
        //hard coded check to check if the client is answering the criteria to be an admin
        //not best practice!! BUT, that's what they asked for...
        if(email.equals(DBmanager.SQL_ADMIN_EMAIL) && password.equals(DBmanager.SQL_ADMIN_PASSWORD)) {
            if (customerDAO.isCustomerExists(email, password))
                return customerDAO.getClientID(email, password);
            else return 0;
        }
        else
            throw new CouponSystemException(ErrorMsg.CLIENT_NOT_ADMIN);
    }
    //endregion
    //region Administrator CRUD Methods
    //region Company CRUD Methods
    public void addCompany(Company company) throws CouponSystemException {
       if(isLogged())
           companiesDAO.addCompany(company);
       else
           throw new CouponSystemException(ErrorMsg.ADMIN_NOT_LOGGED_IN);
    }
    public void updateCompany(Company company) throws CouponSystemException {
        if(isLogged())
            companiesDAO.updateCompany(company);
        else
            throw new CouponSystemException(ErrorMsg.ADMIN_NOT_LOGGED_IN);

    }
    public void deleteCompany(int companyID) throws CouponSystemException {
        if(isLogged())
            companiesDAO.deleteCompany(companyID);
        else
            throw new CouponSystemException(ErrorMsg.ADMIN_NOT_LOGGED_IN);
    }
    public List<Company> getAllCompanies() throws CouponSystemException, SQLException {
        if(isLogged())
            return  companiesDAO.getAllCompanies();
        else
            throw new CouponSystemException(ErrorMsg.ADMIN_NOT_LOGGED_IN);
    }
    public Company getOneCompany(int companyID) throws CouponSystemException, SQLException {
        if(isLogged())
            return  companiesDAO.getOneCompany(companyID);
        else
            throw new CouponSystemException(ErrorMsg.ADMIN_NOT_LOGGED_IN);
    }
    //endregion
    //region Customer CRUD Methods
    public void addCustomer(Customer customer) throws CouponSystemException {
        if(isLogged()){
            customerDAO.addCustomer(customer);
        }
        else
            throw new CouponSystemException(ErrorMsg.ADMIN_NOT_LOGGED_IN);
    }
    public void updateCustomer(Customer customer) throws CouponSystemException {
        if(isLogged()){
            customerDAO.updateCustomer(customer);
        }
        else
            throw new CouponSystemException(ErrorMsg.ADMIN_NOT_LOGGED_IN);
    }
    public void deleteCustomer(int customerID) throws CouponSystemException {
        if(isLogged()){
            customerDAO.deleteCustomer(customerID);
        }
        else
            throw new CouponSystemException(ErrorMsg.ADMIN_NOT_LOGGED_IN);
    }
    public List<Customer> getAllCustomers() throws CouponSystemException, SQLException {
        if(isLogged()){
            return  customerDAO.getAllCustomers();
        }
        else
            throw new CouponSystemException(ErrorMsg.ADMIN_NOT_LOGGED_IN);
    }
    public Customer getOneCustomer(int customerID) throws CouponSystemException, SQLException {
        if(isLogged()){
            return customerDAO.getOneCustomer(customerID);
        }
        else 
            throw new CouponSystemException(ErrorMsg.ADMIN_NOT_LOGGED_IN);
    }
    //endregion
    //endregion


}
