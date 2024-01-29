package facade;

//region Imports
import beans.Client;
import database.dbdao.CompaniesDBDAO;
import database.dbdao.CouponDBDAO;
import database.dbdao.CustomerDBDAO;
import exception.CustomerIsNotAdminException;
import java.sql.SQLException;
//endregion

public abstract class ClientFacade {
    //region Field Declarations
    protected static CustomerDBDAO customerDBDAO = new CustomerDBDAO();
    protected static CompaniesDBDAO companiesDBDAO = new CompaniesDBDAO();
    protected static CouponDBDAO couponDBDAO = new CouponDBDAO();
    private boolean isLogged;
    private final Client client;
    //endregion

    //region Constructor
    // TODO switch login protocol to jwt (for now it's with boolean)
    public ClientFacade(String email,String password) throws CustomerIsNotAdminException, SQLException {
        client = login(email,password);
        setLogged(client.getId()!=-1);
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

    public Client getClient() {return client;}
    //endregion

    //region Abstracted Methods
    public abstract Client login(String email, String password) throws CustomerIsNotAdminException, SQLException;
    //endregion

}
