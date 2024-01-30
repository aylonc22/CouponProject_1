package cls;

import beans.ClientType;
import facade.AdminFacade;
import facade.ClientFacade;
import facade.CompanyFacade;
import facade.CustomerFacade;
import exception.CustomerIsNotAdminException;

import java.sql.SQLException;

public class LoginManager {
    private static LoginManager Instance = null;
    //region Constructor
    private LoginManager() {}
    //endregion

    //region Getters && Setters
    public static LoginManager getInstance() {
        if(Instance == null){
            // DOUBLE CHECK
            synchronized (LoginManager.class){
                if(Instance == null)
                    Instance = new LoginManager();
            }
        }
        return Instance;
    }
    //endregion
    //region Methods
    public ClientFacade login(String email, String password, ClientType clientType) throws CustomerIsNotAdminException, SQLException {
        return switch (clientType) {
            case Company -> new CompanyFacade(email, password);
            case Customer -> new CustomerFacade(email, password);
            case Adminstrator -> new AdminFacade(email, password);
        };
    }
    //endregion
}
