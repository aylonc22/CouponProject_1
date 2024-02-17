package facade;

//region Imports
import beans.Client;
import database.dao.CompaniesDAO;
import database.dao.CouponDAO;
import database.dao.CustomersDAO;
import database.dbdao.CompaniesDBDAO;
import database.dbdao.CouponDBDAO;
import database.dbdao.CustomerDBDAO;
import exception.CustomerIsNotAdminException;
import lombok.Getter;
import lombok.Setter;

import java.sql.SQLException;
//endregion
@Getter
@Setter
public abstract class ClientFacade {
    //region Field Declarations
    protected static CustomersDAO customerDAO = new CustomerDBDAO();
    protected static CompaniesDAO companiesDAO = new CompaniesDBDAO();
    protected static CouponDAO couponDAO = new CouponDBDAO();
    private boolean isLogged;
    private final Client client;
    //endregion

    //region Constructor
    // TODO switch login protocol to jwt (for now it's with boolean)
    public ClientFacade(String email,String password) throws CustomerIsNotAdminException, SQLException {
        client = login(email,password);
        setLogged(client != null);
        System.out.println(isLogged ? "Logged in successfully" : "Login failed");
    }
    //endregion

    //region Abstracted Methods
    public abstract Client login(String email, String password) throws CustomerIsNotAdminException, SQLException;
    //endregion

}
