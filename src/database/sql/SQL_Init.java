package database.sql;

import beans.Category;
import database.sql.commands.*;

import java.util.HashMap;
import java.util.Map;


public class SQL_Init {
    private static void createDB(){
        if( DButils.runQuery(General.CREATE_DB))
           System.out.println("DB Created or already exist");
       else
           System.out.println("DB is not created");
    }
    private static void createCompaniesTable(){
        if( DButils.runQuery(Companies.CREATE_TABLE_COMPANIES))
            System.out.println("TABLE 'companies' Created or already exist");
        else
            System.out.println("TABLE 'companies' is not created");
    }
    private static void createCategoriesTable(){
        if( DButils.runQuery(Categories.CREATE_TABLE_CATEGORIES))
            System.out.println("TABLE 'categories' Created or already exist");
        else
            System.out.println("TABLE 'categories' is not created");
    }
    private static void createCouponsTable(){
        if( DButils.runQuery(Coupons.CREATE_TABLE_COUPONS))
            System.out.println("TABLE 'coupons' Created or already exist");
        else
            System.out.println("TABLE 'coupons' is not created");
    }
    private static void createCvcTable(){
        if( DButils.runQuery(Cvc.CREATE_TABLE_CVC))
            System.out.println("TABLE 'cvc' Created or already exist");
        else
            System.out.println("TABLE 'cvc' is not created");
    }
    private static void createCustomersTable(){
        if( DButils.runQuery(Customers.CREATE_TABLE_CUSTOMERS))
            System.out.println("TABLE customers Created or already exist");
        else
            System.out.println("TABLE customers is not created");
    }
    private static void  insertCategories(){
        Map<Integer,Object> params = new HashMap<>();
        //iterating through all the categories and adding them to params in order to insert them
        for(int index = 0;index<Category.values().length;index++)
        {
            params.put(index+1,Category.values()[index].toString());
        }
        if( DButils.runQuery(Categories.INSERT_CATEGORIES(params.size()),params))
            System.out.println("Categories were inserted or already existed");
        else
            System.out.println("Categories weren't inserted");
    }
    public static void initSQL(){
        createDB();
        createCompaniesTable();
        createCategoriesTable();
        createCustomersTable();
        createCouponsTable();
        createCvcTable();
        insertCategories();

    }
}
