package database.sql;

import beans.Category;
import beans.Company;
import beans.Customer;
import beans.QueryResult;
import database.dbdao.CompaniesDBDAO;
import database.dbdao.CustomerDBDAO;
import database.sql.commands.*;
import exception.SQLDuplicateUniqueKeyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SQL_Init {
    private static void createDB(){
        QueryResult queryResult = DButils.runQuery(General.CREATE_DB);
        if(queryResult.isResult()) {
            System.out.println(DBmanager.SQL_DB+ " created");
        }
       else {
            if (queryResult.getExceptionID() != SQLExceptionErrorCodes.DUPLICATE_KEY
                    && queryResult.getExceptionID() != 0) {
                System.out.println(DBmanager.SQL_DB + "  is not created");
            }
        }
    }
    private static void createCompaniesTable(){
        QueryResult queryResult = DButils.runQuery(Companies.CREATE_TABLE_COMPANIES);
        if(queryResult.isResult()) {
            System.out.println("TABLE " + DBmanager.SQL_COMPANIES + " created");
        }
        else {
            if (queryResult.getExceptionID() != SQLExceptionErrorCodes.DUPLICATE_KEY
                    && queryResult.getExceptionID() != 0) {
                System.out.println("TABLE " + DBmanager.SQL_COMPANIES + " is not created");
            }
        }
    }
    private static void createCategoriesTable(){
        QueryResult queryResult = DButils.runQuery(Categories.CREATE_TABLE_CATEGORIES);
        if(queryResult.isResult()) {
            System.out.println("TABLE " + DBmanager.SQL_CATEGORIES + " created");
        }
        else {
            if (queryResult.getExceptionID() != SQLExceptionErrorCodes.DUPLICATE_KEY
                    && queryResult.getExceptionID() != 0) {
                System.out.println("TABLE " + DBmanager.SQL_CATEGORIES + " is not created");
            }
        }
    }
    private static void createCouponsTable(){
        QueryResult queryResult = DButils.runQuery(Coupons.CREATE_TABLE_COUPONS);
        if(queryResult.isResult()) {
            System.out.println("TABLE " + DBmanager.SQL_COUPONS + " created");
        }
        else {
            if (queryResult.getExceptionID() != SQLExceptionErrorCodes.DUPLICATE_KEY
                    && queryResult.getExceptionID() != 0) {
                System.out.println("TABLE " + DBmanager.SQL_COUPONS + " is not created");
            }
        }
    }
    private static void createCvcTable(){
        QueryResult queryResult = DButils.runQuery(Cvc.CREATE_TABLE_CVC);
        if(queryResult.isResult()) {
            System.out.println("TABLE " + DBmanager.SQL_CVC + " created");
        }
        else {
            if (queryResult.getExceptionID() != SQLExceptionErrorCodes.DUPLICATE_KEY
                    && queryResult.getExceptionID() != 0) {
                System.out.println("TABLE " + DBmanager.SQL_CVC + " is not created");
            }
        }
    }
    private static void createCustomersTable(){
        QueryResult queryResult = DButils.runQuery(Customers.CREATE_TABLE_CUSTOMERS);
        if(queryResult.isResult()) {
            System.out.println("TABLE " + DBmanager.SQL_CUSTOMERS + " created");
        }
        else {
            if (queryResult.getExceptionID() != SQLExceptionErrorCodes.DUPLICATE_KEY
                    && queryResult.getExceptionID() != 0) {
                System.out.println("TABLE " + DBmanager.SQL_CUSTOMERS + " is not created");
            }
        }
    }
    private static void  insertCategories(){
        Map<Integer,Object> params = new HashMap<>();
        //iterating through all the categories and adding them to params in order to insert them
        for(int index = 0;index<Category.values().length;index++)
        {
            params.put(index+1,Category.values()[index].toString());
        }
        QueryResult queryResult = DButils.runQuery(Categories.INSERT_CATEGORIES(params.size()),params);
        if(queryResult.isResult())
            System.out.println(DBmanager.SQL_CATEGORIES + " were inserted");
        else {
            if (queryResult.getExceptionID() != SQLExceptionErrorCodes.DUPLICATE_KEY
                    && queryResult.getExceptionID() != 0) {
                System.out.println(DBmanager.SQL_CATEGORIES + " weren't inserted");
            }
        }
    }

    /**
     * Inserting demo data for showcasing the program
     */
    private static void insertDemoData() throws SQLDuplicateUniqueKeyException {
        new CustomerDBDAO().addCustomer(new Customer("Admin", "Nimda",
                DBmanager.SQL_ADMIN_EMAIL,DBmanager.SQL_ADMIN_PASSWORD));
        new CustomerDBDAO().addCustomer(new Customer("Demmy", "Data",
                "hardCodedCustomer@email.com","12345678"));
        new CompaniesDBDAO().addCompany(new Company("Demmy",
                "hardCodedCompany@email.com","12345678"));

    }
    public static void initSQL(){
        createDB();
        createCompaniesTable();
        createCategoriesTable();
        createCustomersTable();
        createCouponsTable();
        createCvcTable();
        insertCategories();
        try{
            insertDemoData();
        } catch (SQLDuplicateUniqueKeyException e) {
            //There is no reason to panic
            //It just means the demo data is already inside the database...
        }
    }
}
