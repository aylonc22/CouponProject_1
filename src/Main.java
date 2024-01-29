import facade.CompanyFacade;
import database.sql.SQL_Init;
import exception.CustomerIsNotAdminException;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        SQL_Init.initSQL();
        try {
            CompanyFacade company = new CompanyFacade("test@gmail.com","1222132");
            System.out.println(company.getClient());

        } catch (SQLException | CustomerIsNotAdminException e) {
            System.out.println(e);;
        }
    }
}