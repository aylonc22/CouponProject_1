package cls;

import beans.ClientType;
import beans.Company;
import cls.facadeHandlersUtils.AdminFacadeHandler;
import facade.AdminFacade;
import exception.ClientNotLoggedInException;
import exception.CustomerIsNotAdminException;
import java.sql.SQLException;
import java.util.Scanner;

public class SystemManager {
    private static SystemManager Instance = null;
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
    public static SystemManager getInstance() {
       if(Instance == null){
           synchronized (SystemManager.class){
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
                ClientType client = ClientType.values()[index-1];
                switch (client){
                    case Adminstrator -> handleAdminFacadeLogin(scanner);
                    //case Customer -> handleCustomerFacadeLogin();
                    //case Company -> handleCompanyFacadeLogin();
                }
            } catch (Exception e) {
                System.out.println("Wrong value!!, try again...");
            }
        }
    }

    public void handleAdminFacadeLogin(Scanner scanner) {
        System.out.println("To login please enter email");
        scanner.nextLine();
        String email = scanner.nextLine();
        System.out.println("Please enter password");
        String password = scanner.nextLine();
        try {
            AdminFacade adminFacade = (AdminFacade) LoginManager.getInstance().login(email,password, ClientType.Adminstrator);
            handleAdminFacade(adminFacade);
        } catch (CustomerIsNotAdminException | SQLException e) {
            System.out.println("Client is not an admin!! please choose a different login option");
        }

    }

    private void handleAdminFacade(AdminFacade adminFacade) {
        boolean flag = true;
        while (flag){
            AdminFacadeHandler.welcomeAdmin();
            try {
                int index = scanner.nextInt();
                switch (index){
                    case 1: AdminFacadeHandler.addCompany(adminFacade,scanner);
                    case 2: AdminFacadeHandler.updateCompany(adminFacade,scanner);
                    case 3: AdminFacadeHandler.deleteCompany(adminFacade,scanner);
                    case 4: AdminFacadeHandler.showAllCompanies(adminFacade,scanner);
                    case 5: AdminFacadeHandler.showOneCompany(adminFacade,scanner);
                    case 6: AdminFacadeHandler.addCustomer(adminFacade,scanner);
                    case 7: AdminFacadeHandler.updateCustomer(adminFacade,scanner);
                    case 8: AdminFacadeHandler.deleteCustomer(adminFacade,scanner);
                    case 9: AdminFacadeHandler.showAllCustomers(adminFacade,scanner);
                    case 10: AdminFacadeHandler.showOneCustomer(adminFacade,scanner);
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
