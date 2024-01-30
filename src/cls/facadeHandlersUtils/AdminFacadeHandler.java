package cls.facadeHandlersUtils;

import beans.ClientType;
import beans.Company;
import beans.Coupon;
import cls.LoginManager;
import exception.ClientNotLoggedInException;
import exception.CustomerIsNotAdminException;
import facade.AdminFacade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminFacadeHandler {


    //region Admin
    public static void showOneCustomer(AdminFacade adminFacade, Scanner scanner) {
    }

    public static void showAllCustomers(AdminFacade adminFacade, Scanner scanner) {

    }

    public static void deleteCustomer(AdminFacade adminFacade, Scanner scanner) {

    }

    public static void updateCustomer(AdminFacade adminFacade, Scanner scanner) {

    }

    public static void addCustomer(AdminFacade adminFacade, Scanner scanner) {

    }

    public static void showOneCompany(AdminFacade adminFacade, Scanner scanner) {

    }

    public static void showAllCompanies(AdminFacade adminFacade, Scanner scanner) {

    }

    public static void deleteCompany(AdminFacade adminFacade, Scanner scanner) {

    }

    public static void updateCompany(AdminFacade adminFacade, Scanner scanner) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Please enter the ID of the company you want to edit");
        int id = scanner.nextInt();
        System.out.println("Please enter name for company");
        String name = scanner.nextLine();
        System.out.println("Please enter email");
        String email = scanner.nextLine();
        System.out.println("Please enter password");
        String password = scanner.nextLine();
        try {
            adminFacade.updateCompany(new Company(id,name,email,password,new ArrayList<>()));
        } catch (ClientNotLoggedInException e) {
            System.out.println("Admin is not logged in!, please login");;
        }
    }

    /**
     *  A method to add company by an admin
     * @param adminFacade - responsible for controlling 'db_Daoes' method that are available to admin
     * @param scanner - local scanner from system manager for input vars
     */
    public static void addCompany(AdminFacade adminFacade, Scanner scanner) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Please enter name for company");
        String name = scanner.nextLine();
        System.out.println("Please enter email");
        String email = scanner.nextLine();
        System.out.println("Please enter password");
        String password = scanner.nextLine();
        try {
            adminFacade.addCompany(new Company(name,email,password));
        } catch (ClientNotLoggedInException e) {
            System.out.println("Admin is not logged in!, please login");;
        }

    }

    /**
     * Text message with methods an admin can use
     */
    public static void welcomeAdmin() {
        System.out.println("To add a new company type 1");
        System.out.println("To update a company type 2");
        System.out.println("To delete a company type 3");
        System.out.println("To show all companies type 4");
        System.out.println("To show a specific company type 5");
        System.out.println("To add a new customer type 6");
        System.out.println("To update a customer type 7");
        System.out.println("To delete a customer type 8");
        System.out.println("To show all customers type 9");
        System.out.println("To show a specific customer type 10");
        System.out.println("To return to main page type 11");
        System.out.println("To quit type 12");
    }

    //endregion
}
