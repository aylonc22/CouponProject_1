import beans.Customer;
import cls.facade.AdminFacade;
import cls.sql.SQL_Init;
import cls.sql.SQLcommands;
import dao.CustomerDBDAO;
import exception.CustomerIsNotAdminException;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SQL_Init.initSQL();
        new CustomerDBDAO().addCustomer(new Customer("aylon2","cohen","aylonc2@","11111"));
        new CustomerDBDAO().addCustomer(new Customer("aylon1","cohen","aylonc1@","11111"));
        new CustomerDBDAO().addCustomer(new Customer("aylon3","cohen","aylonc3@","11111"));
        try {
            System.out.println(new CustomerDBDAO().getOneCustomer(1));;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}