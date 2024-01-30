package cls;

import beans.*;
import database.sql.ConnectionPool;
import exception.ClientNotLoggedInException;
import exception.CustomerIsNotAdminException;
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
        // Starting the daily job
        CouponExpirationDailyJob job = new CouponExpirationDailyJob();
        Thread task = new Thread(job);
        task.setDaemon(true);
        task.start();

        try{
            //Hard coded showcase of AdminFacade
            showCaseAdminFacade();
            //Hard coded showcase of CompanyFacade
            showCaseCompanyFacade();
            //Hard coded showcase of CustomerFacade
            showCaseCustomerFacade();
            //Handling closing the program
            handleCloseProgram(job);
        }
        catch (InterruptedException e){
            System.out.println("Something went wrong when closing the connection pool");
        }
        catch (ClientNotLoggedInException e){
            System.out.println("Client is not logged in");
        }
         catch (CustomerIsNotAdminException e) {
             System.out.println("User is not and admin");;
        } catch (SQLException e) {
            System.out.println("Something went wrong, unhandled exception");
            System.out.println(e.getMessage());
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
        ConnectionPool.getInstance().closeAllConnections();
    }

    /**
     * ShowCasing the Customer Facade logic and functionalities
     * @throws CustomerIsNotAdminException - Part of ClientFacade, important only to AdminFacade
     * @throws SQLException - An unhandled SQLException
     * @throws ClientNotLoggedInException - A failed attempt to use Facade while not logged in
     */
    private static void showCaseCustomerFacade() throws SQLException, ClientNotLoggedInException, CustomerIsNotAdminException {
        //Login attempt as customer
        CustomerFacade customerFacade = (CustomerFacade) LoginManager.getInstance().login("hardCodedCustomer@email.com","12345678", ClientType.Customer);
        //But coupon attempt
        customerFacade.buyCoupon(1);
        //Get all coupons of customer and print attempt
        customerFacade.getAllCoupons().forEach(System.out::println);
        //Get all coupons from category of customer and print attempt
        customerFacade.getAllCouponsByCategory(Category.Electricity).forEach(System.out::println);
        //Get all coupons from customer by up to price
        customerFacade.getAllCouponsByUpToPrice(6).forEach(System.out::println);
        //Show customer details
        System.out.println(customerFacade.getCustomerDetails());
    }
    /**
     * ShowCasing the Company Facade logic and functionalities
     * @throws CustomerIsNotAdminException - Part of ClientFacade, important only to AdminFacade
     * @throws SQLException - An unhandled SQLException
     * @throws ClientNotLoggedInException - A failed attempt to use Facade while not logged in
     */
    private static void showCaseCompanyFacade() throws ClientNotLoggedInException, CustomerIsNotAdminException, SQLException {
        //Login attempt as company
        CompanyFacade companyFacade = (CompanyFacade) LoginManager.getInstance().login("hardCodedCompany@email.com","12345678", ClientType.Company);
        //Adding coupon attempt
        LocalDate date =  LocalDate.now();
        companyFacade.addCoupon(new Coupon(1, Category.Electricity,"Title","Description", Date.valueOf(date),
                Date.valueOf(date.plusDays(5)),5,5.5,"image"));
        //Updating coupon attempt
        companyFacade.updateCoupon(new Coupon(1,1, Category.Electricity,"TitleChanged","DescriptionChanged", Date.valueOf(date),
                Date.valueOf(date.plusDays(8)),10,5.5,"imageChanged"));
        //Deleting coupon attempt
        companyFacade.deleteCoupon(1);
        //Get all coupons of company and print attempt
        companyFacade.getAllCoupons().forEach(System.out::println);
        //Get all coupons from category of company and print attempt
        companyFacade.getAllCouponsByCategory(Category.Electricity).forEach(System.out::println);
        //Get all coupons from company by up to price
        companyFacade.getAllCouponsByUpToPrice(6).forEach(System.out::println);
        //Show company details
        System.out.println(companyFacade.returnCompanyDetails());
    }
    /**
     * ShowCasing the Admin Facade logic and functionalities
     * @throws CustomerIsNotAdminException - Part of ClientFacade, important only to AdminFacade
     * @throws SQLException - An unhandled SQLException
     * @throws ClientNotLoggedInException - A failed attempt to use Facade while not logged in
     */
    private static void showCaseAdminFacade() throws ClientNotLoggedInException, SQLException, CustomerIsNotAdminException {
        //Login attempt as admin
        AdminFacade adminFacade = (AdminFacade) LoginManager.getInstance().login("admin@admin.com","admin", ClientType.Adminstrator);
        //Adding company attempt
        adminFacade.addCompany(new Company("company","company@email.com","123456789"));
        //Updating company attempt
        adminFacade.updateCompany(new Company(1,"companyChanged","companyChanged@email.com","12345678910",new ArrayList<>()));
        //Deleting company attempt
        adminFacade.deleteCompany(1);
        //Get all companies and print attempt
        adminFacade.getAllCompanies().forEach(System.out::println);
        //Get specific company and print attempt
        System.out.println(adminFacade.getOneCompany(1));
        //Adding customer attempt
        adminFacade.addCustomer(new Customer("Name","LastName","customer@email.com","123456789"));
        //Updating customer attempt
        adminFacade.updateCustomer(new Customer(1,"NameChanged","LastNameChanged","nameChanged@email.com","12345678910",new ArrayList<>()));
        //Deleting customer attempt
        adminFacade.deleteCustomer(1);
        //Get all customers and print attempt
        adminFacade.getAllCustomers().forEach(System.out::println);
        //Get specific customer and print attempt
        System.out.println(adminFacade.getOneCustomer(1));
    }
}
