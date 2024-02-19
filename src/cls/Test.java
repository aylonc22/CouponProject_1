package cls;

import beans.*;
import database.dbdao.CouponDBDAO;
import database.sql.ConnectionPool;
import database.sql.DBmanager;
import database.sql.SQL_Init;
import exception.*;
import facade.AdminFacade;
import facade.CompanyFacade;
import facade.CustomerFacade;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Test {
    /**
     * hard coded test class to check and showcase the coupon system project
     */
    public static void testAll(){
        //Initializing database and its tables
        SQL_Init.initSQL();
        // Starting the daily job
       CouponExpirationDailyJob job = new CouponExpirationDailyJob();
        Thread task = new Thread(job);
        task.setDaemon(true);
        task.start();

       //Showcasing the facades
        try{
            //Hard coded showcase of AdminFacade
                showCaseAdminFacade();

            //Hard coded showcase of CompanyFacade
                showCaseCompanyFacade();

            //Hard coded showcase of CustomerFacade
                showCaseCustomerFacade();

        }
       catch (SQLDuplicateUniqueKeyException | ObjectNotFoundException | ClientNotLoggedInException |
              CustomerIsNotAdminException | OutOfStockException e){
           System.out.println(e.getMessage());
       }
        catch (SQLException e) {
            System.out.println("Something went wrong, unhandled exception");
            System.out.println(e.getMessage());
        }
        //Handling closing the program
        finally {
            System.out.println("The coupon system is shutting down!");
            try {
                handleCloseProgram(job);
            } catch (InterruptedException e) {
                System.out.println("Failed to close connections");;
            }
        }
    }

    /**
     * Responsible for closing safely the program
     * Closing all the open connections and the task in hand
     * @param job - The running job in the back line
     * @throws InterruptedException - An unhandled error while closing the connections
     */
    private static void handleCloseProgram(CouponExpirationDailyJob job) throws InterruptedException {
        job.stop();
        SQL_Init.dropDB();
        ConnectionPool.getInstance().closeAllConnections();

    }

    /**
     * ShowCasing the Customer Facade logic and functionalities
     * @throws CustomerIsNotAdminException - Part of ClientFacade, important only to AdminFacade
     * @throws SQLException - An unhandled SQLException
     * @throws ClientNotLoggedInException - A failed attempt to use Facade while not logged in
     *@throws SQLDuplicateUniqueKeyException - A failed attempt to add or update something with the same unique name
     * @throws ObjectNotFoundException - A failed attempt to use none existing object from SQL
     */
    private static void showCaseCustomerFacade() throws SQLException, ClientNotLoggedInException, CustomerIsNotAdminException, SQLDuplicateUniqueKeyException, ObjectNotFoundException, OutOfStockException {
        //Login attempt as customer
        System.out.println("Customer Login");
        CustomerFacade customerFacade = (CustomerFacade) LoginManager.getInstance().login("hardCodedCustomer@email.com","12345678", ClientType.Customer);

        //Buy coupon attempt
        System.out.println("Buy coupon attempt");
        customerFacade.buyCoupon(1);

        //Get all coupons of customer and print attempt
        System.out.println("All coupons");
        customerFacade.getAllCoupons().forEach(System.out::println);

        //Get all coupons from category of customer and print attempt
        System.out.println("All coupons by category");
        customerFacade.getAllCouponsByCategory(Category.Electricity).forEach(System.out::println);

        //Get all coupons from customer by up to price
        System.out.println("All coupons by up to price");
        customerFacade.getAllCouponsByUpToPrice(6).forEach(System.out::println);

        //Show customer details
        System.out.println("Customer Details");
        System.out.println(customerFacade.getCustomerDetails());
    }
    /**
     * ShowCasing the Company Facade logic and functionalities
     * @throws CustomerIsNotAdminException - Part of ClientFacade, important only to AdminFacade
     * @throws SQLException - An unhandled SQLException
     * @throws ClientNotLoggedInException - A failed attempt to use Facade while not logged in
     * @throws SQLDuplicateUniqueKeyException - A failed attempt to add or update something with the same unique name
     * @throws ObjectNotFoundException - A failed attempt to use none existing object from SQL
     */
    private static void showCaseCompanyFacade() throws ClientNotLoggedInException, CustomerIsNotAdminException, SQLException, SQLDuplicateUniqueKeyException, ObjectNotFoundException {
        //Login attempt as company
        System.out.println("Company login");
        CompanyFacade companyFacade = (CompanyFacade) LoginManager.getInstance().login("hardCodedCompany@email.com","12345678", ClientType.Company);

        //Adding coupon attempt
        LocalDate date =  LocalDate.now();
        System.out.println("Adding coupon");
        companyFacade.addCoupon(new Coupon(1, Category.Electricity,"Title","Description", Date.valueOf(date),
                Date.valueOf(date.plusDays(5)),5,5.5,"image"));

        //Updating coupon attempt
        System.out.println("Updating coupon");
        companyFacade.updateCoupon(new Coupon(5,1, Category.Electricity,"TitleChanged","DescriptionChanged", Date.valueOf(date),
                Date.valueOf(date.plusDays(8)),10,5.5,"imageChanged"));

        //Deleting coupon attempt
        System.out.println("Deleting coupon");
        companyFacade.deleteCoupon(4);

        //Get all coupons of company and print attempt
        System.out.println("All coupons");
        companyFacade.getAllCoupons().forEach(System.out::println);

        //Get all coupons from category of company and print attempt
        System.out.println("All coupons by category");
        companyFacade.getAllCouponsByCategory(Category.Electricity).forEach(System.out::println);

        //Get all coupons from company by up to price
        System.out.println("All coupons by up to price");
        companyFacade.getAllCouponsByUpToPrice(6).forEach(System.out::println);

        //Show company details
        System.out.println("Company Details");
        System.out.println(companyFacade.returnCompanyDetails());
    }
    /**
     * ShowCasing the Admin Facade logic and functionalities
     * @throws CustomerIsNotAdminException - Part of ClientFacade, important only to AdminFacade
     * @throws SQLException - An unhandled SQLException
     * @throws ClientNotLoggedInException - A failed attempt to use Facade while not logged in
     * @throws SQLDuplicateUniqueKeyException - A failed attempt to add or update something with the same unique name
     * @throws ObjectNotFoundException - A failed attempt to use none existing object from SQL
     */
    private static void showCaseAdminFacade() throws ClientNotLoggedInException, SQLException, CustomerIsNotAdminException, SQLDuplicateUniqueKeyException, ObjectNotFoundException {
        //Login attempt as admin
        System.out.println("Admin loging");
        AdminFacade adminFacade = (AdminFacade) LoginManager.getInstance().login(DBmanager.SQL_ADMIN_EMAIL,
                DBmanager.SQL_ADMIN_PASSWORD, ClientType.Adminstrator);

        //Adding company attempt
        System.out.println("Adding company");
        adminFacade.addCompany(new Company("company","company@email.com","123456789"));

        //Updating company attempt
        System.out.println("Updating company");
         adminFacade.updateCompany(new Company(3,"companyChanged","companyChanged@email.com","12345678910",new ArrayList<>()));

        //Deleting company attempt
        System.out.println("Deleting company");
        adminFacade.deleteCompany(3);

        //Get all companies and print attempt
        System.out.println("All companies");
        adminFacade.getAllCompanies().forEach(System.out::println);

        //Get specific company and print attempt
        System.out.println("Specific Company");
        System.out.println(adminFacade.getOneCompany(1));

        //Adding customer attempt
        System.out.println("Add customer");
        adminFacade.addCustomer(new Customer("Name","LastName","customer@email.com","123456789"));

        //Updating customer attempt
        System.out.println("Update customer");
        adminFacade.updateCustomer(new Customer(4,"NameChanged","LastNameChanged","nameChanged@email.com","12345678910",new ArrayList<>()));

        //Deleting customer attempt
        System.out.println("Deleting customer");
        adminFacade.deleteCustomer(4);

        //Get all customers and print attempt
        System.out.println("All customers");
        adminFacade.getAllCustomers().forEach(System.out::println);

        //Get specific customer and print attempt
        System.out.println("Specific customer");
        System.out.println(adminFacade.getOneCustomer(3));
    }
}
