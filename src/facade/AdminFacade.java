package facade;

import beans.Client;
import beans.ClientType;
import beans.Company;
import beans.Customer;
import database.sql.DBmanager;
import exception.ClientNotLoggedInException;
import exception.CustomerIsNotAdminException;
import exception.ObjectNotFoundException;
import exception.SQLDuplicateUniqueKeyException;

import java.sql.SQLException;
import java.util.List;

public class AdminFacade extends ClientFacade {
    //region Constructors
    public AdminFacade(String email,String password) throws CustomerIsNotAdminException, SQLException {
        super(email,password);
    }
    //endregion

    //region Overrides
    @Override
    public Client login(String email, String password) throws CustomerIsNotAdminException, SQLException {
        //hard coded check to check if the client is answering the criteria to be an admin
        //not best practice!! BUT, that's what they asked for...
        if(email.equals(DBmanager.SQL_ADMIN_EMAIL) && password.equals(DBmanager.SQL_ADMIN_PASSWORD)) {
            if (customerDAO.isCustomerExists(email, password))
                return customerDAO.getClient(email, password);
            else
                return null;
        }
        else
            throw new CustomerIsNotAdminException("The client is not an administrator");
    }
    //endregion
    //region Administrator CRUD Methods
    //region Company CRUD Methods
    public void addCompany(Company company) throws ClientNotLoggedInException, SQLDuplicateUniqueKeyException {
       if(isLogged())
           companiesDAO.addCompany(company);
       else
           throw new ClientNotLoggedInException(ClientType.Adminstrator);
    }
    public void updateCompany(Company company) throws ClientNotLoggedInException, SQLDuplicateUniqueKeyException, ObjectNotFoundException {
        if(isLogged())
            companiesDAO.updateCompany(company);
        else
            throw new ClientNotLoggedInException(ClientType.Adminstrator);

    }
    public void deleteCompany(int companyID) throws ClientNotLoggedInException, ObjectNotFoundException {
        if(isLogged())
            companiesDAO.deleteCompany(companyID);
        else
            throw new ClientNotLoggedInException(ClientType.Adminstrator);
    }
    public List<Company> getAllCompanies() throws ClientNotLoggedInException, SQLException {
        if(isLogged())
            return  companiesDAO.getAllCompanies();
        else
            throw new ClientNotLoggedInException(ClientType.Adminstrator);
    }
    public Company getOneCompany(int companyID) throws ClientNotLoggedInException, SQLException, ObjectNotFoundException {
        if(isLogged())
            return  companiesDAO.getOneCompany(companyID);
        else
            throw new ClientNotLoggedInException(ClientType.Adminstrator);
    }
    //endregion
    //region Customer CRUD Methods
    public void addCustomer(Customer customer) throws ClientNotLoggedInException, SQLDuplicateUniqueKeyException {
        if(isLogged()){
            customerDAO.addCustomer(customer);
        }
        else
            throw new ClientNotLoggedInException(ClientType.Adminstrator);
    }
    public void updateCustomer(Customer customer) throws ClientNotLoggedInException, ObjectNotFoundException, SQLDuplicateUniqueKeyException {
        if(isLogged()){
            customerDAO.updateCustomer(customer);
        }
        else
            throw new ClientNotLoggedInException(ClientType.Adminstrator);
    }
    public void deleteCustomer(int customerID) throws ClientNotLoggedInException, ObjectNotFoundException {
        if(isLogged()){
            customerDAO.deleteCustomer(customerID);
        }
        else
            throw new ClientNotLoggedInException(ClientType.Adminstrator);
    }
    public List<Customer> getAllCustomers() throws ClientNotLoggedInException, SQLException {
        if(isLogged()){
            return  customerDAO.getAllCustomers();
        }
        else
            throw new ClientNotLoggedInException(ClientType.Adminstrator);
    }
    public Customer getOneCustomer(int customerID) throws ClientNotLoggedInException, SQLException, ObjectNotFoundException {
        if(isLogged()){
            return customerDAO.getOneCustomer(customerID);
        }
        else
            throw new ClientNotLoggedInException(ClientType.Adminstrator);
    }
    //endregion
    //endregion


}
