package cls.facade;

import dao.CompaniesDBDAO;
import dao.CouponDBDAO;
import dao.CustomerDBDAO;
import exception.CustomerIsNotAdminException;

import java.sql.SQLException;

public abstract class ClientFacade {
    //region Field Declarations
    protected CustomerDBDAO customerDBDAO = new CustomerDBDAO();
    protected CompaniesDBDAO companiesDBDAO = new CompaniesDBDAO();
    protected CouponDBDAO couponDBDAO;
    private boolean isLogged;
    //endregion

    //region Constructor
    // TODO switch login protocol to jwt (for now it's with boolean)
    public ClientFacade(String email,String password) throws CustomerIsNotAdminException, SQLException {
        setLogged(login(email,password));
        System.out.println(isLogged ? "Logged in successfully" : "Login failed");
    }
    //endregion

    //region Setters && Getters
    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }
    //endregion

    //region Abstracted Methods
    public abstract boolean login(String email, String password) throws CustomerIsNotAdminException, SQLException;
    //endregion

}
