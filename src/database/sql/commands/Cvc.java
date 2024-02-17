package database.sql.commands;

import database.sql.DBmanager;

public class Cvc {
    /**
     * A Query responsible for creating the customers_vs_coupons table when initializing the project
     */
    public static final String CREATE_TABLE_CVC=
            "CREATE TABLE IF NOT EXISTS " + DBmanager.SQL_DB + "." + DBmanager.SQL_CVC + "(" +
                    "  `Customer_ID` INT NOT NULL," +
                    "  `Coupon_ID` INT NOT NULL," +
                    "  PRIMARY KEY (`Customer_ID`, `Coupon_ID`)," +
                    "  INDEX `Coupons_ID_idx` (`Coupon_ID` ASC) VISIBLE," +
                    "  CONSTRAINT `Customer_ID`" +
                    "    FOREIGN KEY (`Customer_ID`)" +
                    "    REFERENCES " + DBmanager.SQL_DB + "." + DBmanager.SQL_CUSTOMERS + " (`ID`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE," +
                    "  CONSTRAINT `Coupons_ID`" +
                    "    FOREIGN KEY (`Coupon_ID`)" +
                    "    REFERENCES " +DBmanager.SQL_DB +"." + DBmanager.SQL_COUPONS + " (`ID`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE);";
    //region Implementation for Customer_Vs_Coupon table
    /**
     * One out of 2 steps insert process
     * A query responsible for INSERTING a new coupon purchased record
     * ONLY if there are enough in the stock
     */
    public static final String ADD_CVC_STEP1 = "INSERT INTO " + DBmanager.SQL_DB + "." + DBmanager.SQL_CVC +
            " (Customer_ID,Coupon_ID)" +
            " SELECT ?,?" +
            " WHERE EXISTS (SELECT 1 FROM " + DBmanager.SQL_DB + "."+ DBmanager.SQL_COUPONS + " WHERE ID=? AND Amount >=1);";
    /**
     * TWO out of 2 steps insert process
     * A query responsible for UPDATING the Amount colum to its value minus one
     * This query will run only if step 1  will work
     */
    public static final String ADD_CVC_STEP2 = " UPDATE " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +
            " SET Amount = Amount - 1 WHERE ID=?";
    /**
     * Exception checker
     * A query responsible for CHECKING if coupon is out of stock (Amount = 0)
     * This query will run only if step 1 will fail
     */
    public static final String VALIDATE_OUT_OF_STOCK = "SELECT COUNT(*) FROM "+ DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +
            " WHERE ID=? AND AMOUNT = 0";

    /**
     * A query responsible for DELETING one purchased by record from the database (does not increment the
     * value of the current stock [Amount] of the coupon)
     */
    public static final String DELETE_CVC = "DELETE FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_CVC + " WHERE Customer_ID=? AND Coupon_ID=?";
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //
    //
    //
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    /**
     * A query responsible for RETURNING all the purchased coupon of a customer
     * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     * aliases
     * cvc stands for customer_vs_coupon
     * coup stands for coupon
     * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     */
    public static final String GET_ALL_COUPON_OF_CUSTOMER = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +
            " coup JOIN " + DBmanager.SQL_DB + "." + DBmanager.SQL_CVC + " cvc ON coup.ID=cvc.Coupon_ID"+
            " WHERE cvc.Customer_ID = ?";
    /**
     * A query responsible for RETURNING all the purchased coupon of a customer by category
     * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     * aliases
     * cvc stands for customer_vs_coupon
     * coup stands for coupon
     * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     */
    public static final String GET_ALL_COUPON_OF_CUSTOMER_BY_CATEGORY = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +
            " coup JOIN " + DBmanager.SQL_DB + "." + DBmanager.SQL_CVC + " cvc ON coup.ID=cvc.Coupon_ID"+
            " WHERE cvc.Customer_ID = ? AND coup.Category_ID = ?";
    /**
     * A query responsible for RETURNING all the purchased coupon of a customer by up to price
     * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     * aliases
     * cvc stands for customer_vs_coupon
     * coup stands for coupon
     * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     */
    public static final String GET_ALL_COUPON_OF_CUSTOMER_UP_TO_PRICE = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +
            " coup JOIN " + DBmanager.SQL_DB + "." + DBmanager.SQL_CVC + " cvc ON coup.ID=cvc.Coupon_ID"+
            " WHERE cvc.Customer_ID = ? AND coup.Price <= ?";;
    //endregion
}
