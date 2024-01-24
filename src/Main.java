import beans.Company;
import beans.Customer;
import cls.facade.AdminFacade;
import cls.sql.SQL_Init;
import cls.sql.SQLcommands;
import dao.CompaniesDBDAO;
import dao.CustomerDBDAO;
import exception.CustomerIsNotAdminException;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SQL_Init.initSQL();
        new CompaniesDBDAO().updateCompany(new Company(2,"aylon33cohen","aylonc333@","11111",new ArrayList<>()));
        try {
            System.out.println( new CompaniesDBDAO().getOneCompany(1));;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}