import cls.SystemManager;
import facade.CompanyFacade;
import database.sql.SQL_Init;
import exception.CustomerIsNotAdminException;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        SQL_Init.initSQL();
        SystemManager.getInstance();
    }
}