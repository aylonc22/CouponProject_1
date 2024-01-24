package cls.facade;

import dao.CompaniesDBDAO;
import dao.CouponDBDAO;
import dao.CustomerDBDAO;
import exception.CustomerIsNotAdminException;

public abstract class ClientFacade {
    //region Field Declarations
    protected CustomerDBDAO customerDBDAO;
    protected CompaniesDBDAO companiesDBDAO;
    protected CouponDBDAO couponDBDAO;
    private boolean isLogged;
    //endregion

    //region Constructor
    //TODO check if login in abstract works for each facade
    public ClientFacade(String email,String password) throws CustomerIsNotAdminException {
        setLogged(login(email,password));
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
    public abstract boolean login(String email, String password) throws CustomerIsNotAdminException;
    //endregion

}
