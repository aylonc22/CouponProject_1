package cls.facade;

import beans.Company;
import beans.Customer;
import exception.ClientNotLoggedInException;
import exception.CustomerIsNotAdminException;

import java.sql.SQLException;
import java.util.List;

public class AdminFacade extends ClientFacade{
    public AdminFacade(String email,String password) throws CustomerIsNotAdminException, SQLException {
        super(email,password);
    }

    //region Overrides
    @Override
    public boolean login(String email, String password) throws CustomerIsNotAdminException, SQLException {
        //hard coded check to check if the client is answering the criteria to be an admin
        //not best practice!! BUT, that's what they asked for...
        if(email.equals("admin@admin.com") && password.equals("admin"))
            return super.customerDBDAO.isCustomerExists(email,password);
        else
            throw new CustomerIsNotAdminException("The client is not an administrator");
    }
    //endregion
    //region Administrator CRUD Methods
    //region Company CRUD Methods
    public void addCompany(Company company) throws ClientNotLoggedInException {
       if(super.isLogged())
           super.companiesDBDAO.addCompany(company);
       else
           throw new ClientNotLoggedInException("Admin is not logged in");
    }
    public void updateCompany(Company company) throws ClientNotLoggedInException {
        if(super.isLogged())
            super.companiesDBDAO.updateCompany(company);
        else
            throw new ClientNotLoggedInException("Admin is not logged in");

    }
    public void deleteCompany(int companyID) throws ClientNotLoggedInException {
        if(super.isLogged())
            super.companiesDBDAO.deleteCompany(companyID);
        else
            throw new ClientNotLoggedInException("Admin is not logged in");
    }
    public List<Company> getAllCompanies() throws ClientNotLoggedInException, SQLException {
        if(super.isLogged())
            return  super.companiesDBDAO.getAllCompanies();
        else
            throw new ClientNotLoggedInException("Admin is not logged in");
    }
    public Company getOneCompany(int companyID) throws ClientNotLoggedInException, SQLException {
        if(super.isLogged())
            return  super.companiesDBDAO.getOneCompany(companyID);
        else
            throw new ClientNotLoggedInException("Admin is not logged in");
    }
    //endregion
    //region Customer CRUD Methods
    public void addCustomer(Customer customer) throws ClientNotLoggedInException {
        if(isLogged()){
            super.customerDBDAO.addCustomer(customer);
        }
        else
            throw new ClientNotLoggedInException("Admin is not logged in");
    }
    public void updateCustomer(Customer customer) throws ClientNotLoggedInException {
        if(isLogged()){
            super.customerDBDAO.updateCustomer(customer);
        }
        else
            throw new ClientNotLoggedInException("Admin is not logged in");
    }
    public void deleteCustomer(int customerID) throws ClientNotLoggedInException {
        if(isLogged()){
            super.customerDBDAO.deleteCustomer(customerID);
        }
        else
            throw new ClientNotLoggedInException("Admin is not logged in");
    }
    public List<Customer> getAllCustomers() throws ClientNotLoggedInException, SQLException {
        if(isLogged()){
            return  super.customerDBDAO.getAllCustomers();
        }
        else
            throw new ClientNotLoggedInException("Admin is not logged in");
    }
    public Customer getOneCustomer(int customerID) throws ClientNotLoggedInException, SQLException {
        if(isLogged()){
            return super.customerDBDAO.getOneCustomer(customerID);
        }
        else
            throw new ClientNotLoggedInException("Admin is not logged in");
    }
    //endregion
    //endregion


}
