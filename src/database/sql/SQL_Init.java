package database.sql;

import beans.*;
import database.dbdao.CompaniesDBDAO;
import database.dbdao.CouponDBDAO;
import database.dbdao.CustomerDBDAO;
import database.sql.commands.*;
import exception.CouponSystemException;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class SQL_Init {
    private static void createDB(){
        QueryResult queryResult = DButils.runQuery(General.CREATE_DB);
        handleInsertTable(queryResult,DBmanager.SQL_DB);
    }
    public static void dropDB(){
        QueryResult queryResult = DButils.runQuery(General.DROP_DATABASE);
        if(queryResult.isResult()){
            System.out.println(DBmanager.SQL_DB + " database is dropped");
        }
    }
    private static void createCompaniesTable(){
        QueryResult queryResult = DButils.runQuery(Companies.CREATE_TABLE_COMPANIES);
        handleInsertTable(queryResult,DBmanager.SQL_COMPANIES);
    }
    private static void createCategoriesTable(){
        QueryResult queryResult = DButils.runQuery(Categories.CREATE_TABLE_CATEGORIES);
        handleInsertTable(queryResult,DBmanager.SQL_CATEGORIES);
    }
    private static void createCouponsTable(){
        QueryResult queryResult = DButils.runQuery(Coupons.CREATE_TABLE_COUPONS);
        handleInsertTable(queryResult,DBmanager.SQL_COUPONS);
    }
    private static void createCvcTable(){
        QueryResult queryResult = DButils.runQuery(Cvc.CREATE_TABLE_CVC);
        handleInsertTable(queryResult,DBmanager.SQL_CVC);
    }
    private static void createCustomersTable(){
        QueryResult queryResult = DButils.runQuery(Customers.CREATE_TABLE_CUSTOMERS);
        handleInsertTable(queryResult,DBmanager.SQL_CUSTOMERS);
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
    private static void handleInsertTable(QueryResult queryResult,String table){
        if(queryResult.isResult()) {
            System.out.println(table + " created");
        }
        else {
            if (queryResult.getExceptionID() != SQLExceptionErrorCodes.DUPLICATE_KEY
                    && queryResult.getExceptionID() != 0) {
                System.out.println(table + " is not created");
            }
        }
    }
    /**
     * Inserting demo data for showcasing the program
     */
    private static void insertDemoData() throws CouponSystemException, SQLException {
        //Adding demmy companies
        new CompaniesDBDAO().addCompany(new Company("Demmy",
                "hardCodedCompany@email.com","12345678"));
        new CompaniesDBDAO().addCompany(new Company("Demy",
                "hardCodedCompany22@email.com","12345678"));
        //Adding coupons to company
        LocalDate date =  LocalDate.now();
        new CouponDBDAO().addCoupon(new Coupon(2
                ,Category.Electricity
                ,"lamp","30% on lamps"
                ,Date.valueOf(date),Date.valueOf(date.plusDays(5)),
                5
                ,5.0,
                "awesomePicture"));
        new CouponDBDAO().addCoupon(new Coupon(2
                ,Category.Electricity
                ,"bulb"
                ,"30% on bulb"
                , Date.valueOf(date)
                ,Date.valueOf(date.plusDays(5))
                ,5
                ,5.0
                ,"awesomePicture"));
        new CouponDBDAO().addCoupon(new Coupon(2
                ,Category.Electricity
                ,"bulbs"
                ,"45% on bulb"
                , Date.valueOf(date.minusDays(10))
                ,Date.valueOf(date.minusDays(5))
                ,5
                ,5.0
                ,"awesomePicture"));
        new CouponDBDAO().addCoupon(new Coupon(1
                ,Category.Electricity
                ,"bulb"
                ,"30% on bulb"
                , Date.valueOf(date)
                ,Date.valueOf(date.plusDays(5))
                ,5
                ,5.0
                ,"awesomePicture"));
        //Adding admin and demmy customers
        new CustomerDBDAO().addCustomer(new Customer("Admin", "Nimda",
                DBmanager.SQL_ADMIN_EMAIL,DBmanager.SQL_ADMIN_PASSWORD));
        new CustomerDBDAO().addCustomer(new Customer("Demmy", "Data",
                "hardCodedCustomer@email.com","12345678"));
        new CustomerDBDAO().addCustomer(new Customer("Demmy2", "Data",
                "hardCodedCustomer22@email.com","12345678"));
        //Adding coupon to customer
        new CouponDBDAO().addCouponPurchase(3,3);
        new CouponDBDAO().addCouponPurchase(3,2);
        new CouponDBDAO().addCouponPurchase(3,1);

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
            System.out.println("Adding demo data...");
            insertDemoData();
        } catch (CouponSystemException | SQLException e) {
            //There is no reason to panic
            //It just means the demo data is already inside the database...
        }
    }
}
