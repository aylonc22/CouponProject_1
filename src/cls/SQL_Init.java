package cls;

import java.util.HashMap;
import java.util.Map;

public class SQL_Init {
    private static void createDB(){
        if( DButils.runQuery(SQLcommands.CREATE_DB))
           System.out.println("DB Created or already exist");
       else
           System.out.println("DB is not created");
    }
    private static void createCompaniesTable(){
        if( DButils.runQuery(SQLcommands.CREATE_TABLE_COMPANIES))
            System.out.println("TABLE 'companies' Created or already exist");
        else
            System.out.println("TABLE 'companies' is not created");
    }
    private static void createCategoriesTable(){
        if( DButils.runQuery(SQLcommands.CREATE_TABLE_CATEGORIES))
            System.out.println("TABLE 'categories' Created or already exist");
        else
            System.out.println("TABLE 'categories' is not created");
    }
    private static void createCouponsTable(){
        if( DButils.runQuery(SQLcommands.CREATE_TABLE_COUPONS))
            System.out.println("TABLE 'coupons' Created or already exist");
        else
            System.out.println("TABLE 'coupons' is not created");
    }
    private static void createCvcTable(){
        if( DButils.runQuery(SQLcommands.CREATE_TABLE_CVC))
            System.out.println("TABLE 'cvc' Created or already exist");
        else
            System.out.println("TABLE 'cvc' is not created");
    }
    private static void createCustomersTable(){
        if( DButils.runQuery(SQLcommands.CREATE_TABLE_CUSTOMERS))
            System.out.println("TABLE customers Created or already exist");
        else
            System.out.println("TABLE customers is not created");
    }
    public static void initSQL(){
        createDB();
        createCompaniesTable();
        createCategoriesTable();
        createCustomersTable();
        createCouponsTable();
        createCvcTable();
    }
}
