package cls;

import beans.ClientType;
import beans.Company;
import facade.AdminFacade;
import exception.ClientNotLoggedInException;
import exception.CustomerIsNotAdminException;
import java.sql.SQLException;
import java.util.Scanner;

public class SystemManager {
    private SystemManager Instance = null;
    private boolean systemFlag;
    private final Scanner scanner;
    //region Constructor
    private SystemManager() {
        scanner = new Scanner(System.in);
        systemFlag = true;
        startSystem();
    }
    //endregion

    //region Setters && Getters
    public SystemManager getInstance() {
       if(Instance == null){
           synchronized (this.getClass()){
               if(Instance == null){
                   Instance = new SystemManager();
               }
           }
       }
       return Instance;
    }
    //endregion
    //region Methods
    private void startSystem() {
        startDailyJob();
        inputHandle();
    }

    private void inputHandle() {
        boolean isFirst = true;
        // systemFlag is responsible for stopping the while loop
        while(systemFlag){
            welcome(isFirst);
            if(isFirst){
                isFirst = false;
            }
            try {
                int index = scanner.nextInt();
                if(index==4){
                    System.out.println("BYE BYE");
                    systemFlag = false;
                    break;
                }
                ClientType client = ClientType.values()[index];
                switch (client){
                    case Adminstrator -> handleAdminFacadeLogin();
                    case Customer -> handleCustomerFacadeLogin();
                    case Company -> handleCompanyFacadeLogin();
                }
            } catch (Exception e) {
                System.out.println("Wrong value!!, try again...");
            }
        }
    }

    private void handleAdminFacadeLogin() {
        System.out.println("To login please enter email");
        String email = scanner.nextLine();
        System.out.println("Please enter password");
        String password = scanner.nextLine();
        try {
            AdminFacade adminFacade = new AdminFacade(email,password);
            handleAdminFacade(adminFacade);
        } catch (CustomerIsNotAdminException | SQLException e) {
            System.out.println("Client is not an admin!! please choose a different login option");
        }

    }

    private void handleAdminFacade(AdminFacade adminFacade) {
        boolean flag = true;
        while (flag){
            welcomeAdmin();
            try {
                int index = scanner.nextInt();
                switch (index){
                    case 1: addCompany(adminFacade);
                    case 2: updateCompany(adminFacade);
                    case 3: deleteCompany(adminFacade);
                    case 4: showAllCompanies(adminFacade);
                    case 5: showOneCompany(adminFacade);
                    case 6: addCustomer(adminFacade);
                    case 7: updateCustomer(adminFacade);
                    case 8: deleteCustomer(adminFacade);
                    case 9: showAllCustomers(adminFacade);
                    case 10: showOneCustomer(adminFacade);
                    case 11: flag = false;
                    case 12:
                        flag = false;
                        systemFlag = false;
                    default:
                        System.out.println("Please enter a valid number");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number");
            }
        }
    }

    //region Admin
    private void showOneCustomer() {
    }

    private void showAllCustomers() {

    }

    private void deleteCustomer() {

    }

    private void updateCustomer() {

    }

    private void addCustomer() {

    }

    private void showOneCompany() {

    }

    private void showAllCompanies() {

    }

    private void deleteCompany() {

    }

    private void updateCompany() {

    }
    //Fields of company Integer id, String name, String email, String password, List<Coupon> coupons
    private void addCompany(AdminFacade adminFacade) {
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
            throw new RuntimeException(e);
        }

    }

    private void welcomeAdmin() {
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

    private void welcome(boolean isFirstTime) {
       if(isFirstTime){
           System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
           System.out.println("Welcome to coupon system");
       }
        System.out.println("To login as admin type 1");
        System.out.println("To login as customer type 2");
        System.out.println("To login as company type 3");
        System.out.println("To quit type 4");
    }

    private void startDailyJob() {
        Thread task = new Thread(new CouponExpirationDailyJob());
        task.setDaemon(true);
        task.start();
    }
    //endregion
}
