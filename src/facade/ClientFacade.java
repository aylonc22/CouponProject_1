package facade;

//region Imports
import beans.Client;
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
       if(client != null){
           setLogged(client.getId()!=-1);
       }

        System.out.println(isLogged ? "Logged in successfully" : "Login failed");
    }
    //endregion

    //region Abstracted Methods
    public abstract Client login(String email, String password) throws CustomerIsNotAdminException, SQLException;
    //endregion

}
